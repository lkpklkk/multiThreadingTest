package com.company.jmhtesting;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author lekeping
 */
public class JmhMain {

    @State(Scope.Thread)

    public static class OfficialTest {
        private ExecutorService executorService;
        private Runnable runnable;
        @Param({"1", "5", "6", "7", "10", "20", "100", "200"})
        int threadNum;
        int taskNum = 300;
        @Param({"1", "2", "3"})
        int taskType;

        public static void main(String[] args) throws RunnerException {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Options opt = new OptionsBuilder()
                    .addProfiler("stack")
                    .include(OfficialTest.class.getSimpleName())
                    .forks(2)
                    .warmupIterations(1)
                    .warmupForks(1)
                    .mode(Mode.AverageTime) //Calculate number of operations in a time unit.//Calculate an average running time per operation
                    .timeUnit(TimeUnit.MILLISECONDS)
                    .measurementTime(new TimeValue(10, TimeUnit.SECONDS))
                    .measurementIterations(5)
                    .build();

            new Runner(opt).run();
        }

        @Setup(Level.Invocation)
        public void setUp() {
            executorService = Executors.newFixedThreadPool(threadNum);
            switch (taskType) {
                case 1:
                    runnable = new RunnableTask(new AlmostCpu(100));
                    break;
                case 2:
                    runnable = new RunnableTask(new AlmostIo(100));
                    break;
                case 3:
                    runnable = new RunnableTask(new InBetween(100));
                    break;
                default:
                    break;
            }
        }

        @Benchmark
        public boolean test() throws InterruptedException {
            for (int i = 0; i < taskNum; i++) {
                executorService.execute(runnable);
            }
            executorService.shutdown();
            return executorService.awaitTermination(50, TimeUnit.SECONDS);
        }
    }

    @State(Scope.Thread)
    @Warmup(iterations = 0)
    @BenchmarkMode(Mode.Throughput)
    public static class StandAloneTask {
        Task task;
        @Param
        int taskType;

        @Setup(Level.Iteration)
        public void setUp() {
            switch (taskType) {
                case 1:
                    task = new AlmostCpu(100);
                    break;
                case 2:
                    task = new AlmostIo(100);
                    break;
                case 3:
                    task = new InBetween(100);
                    break;
                default:
                    break;
            }
        }

        public static void main(String[] args) throws RunnerException {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Options opt = new OptionsBuilder()
                    .addProfiler("stack")
                    .include(StandAloneTask.class.getSimpleName())
                    .forks(2)
                    .warmupIterations(1)
                    .warmupForks(0)
                    .mode(Mode.Throughput) //Calculate number of operations in a time unit.//Calculate an average running time per operation
                    .timeUnit(TimeUnit.MILLISECONDS)
                    .measurementTime(new TimeValue(5, TimeUnit.SECONDS))
                    .measurementIterations(5)
                    .build();

            new Runner(opt).run();
        }


        @Benchmark
        public void benchMark() throws InterruptedException {

            task.run();

        }
    }

}
