package com.company;

import com.company.runnable.BubbleSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class JmhTesting {

    @State(Scope.Thread)

    public static class expe1 {
        private ExecutorService executorService;
        private Runnable runnable;
        @Param({"1", "5", "6", "7", "10", "20", "100", "200"})
        int threadNum;
        int taskNum = 500;

        public static void main(String[] args) throws RunnerException {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Options opt = new OptionsBuilder()
                    .addProfiler("stack")
                    .include(JmhTesting.expe1.class.getSimpleName())
                    .forks(2)
                    .warmupIterations(1)
                    .warmupForks(1)
                    .mode(Mode.AverageTime) //Calculate number of operations in a time unit.//Calculate an average running time per operation
                    .timeUnit(TimeUnit.MILLISECONDS)
                    .measurementTime(new TimeValue(5, TimeUnit.SECONDS))
                    .measurementIterations(5)
                    .build();

            new Runner(opt).run();
        }

        @Setup(Level.Invocation)
        public void setUp() {
            executorService = Executors.newFixedThreadPool(threadNum);
            runnable = new BubbleSort();
        }

        @Benchmark
        public void test() throws InterruptedException {
            for (int i = 0; i < taskNum; i++) {
                executorService.execute(runnable);
            }
            executorService.shutdown();
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        }
    }

    @State(Scope.Thread)
    @Warmup(iterations = 0)
    @BenchmarkMode(Mode.Throughput)
    public static class singleThreadAllCpu {
        private static final int taskNum = 500;
        Thread thread;

        @Setup(Level.Invocation)
        public void setUp() {
            thread = new Thread(new BubbleSort(taskNum));
        }

        public static void main(String[] args) throws RunnerException {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Options opt = new OptionsBuilder()
                    .addProfiler("stack")
                    .include(singleThreadAllCpu.class.getSimpleName())
                    .forks(2)
                    .warmupIterations(1)
                    .warmupForks(1)
                    .mode(Mode.AverageTime) //Calculate number of operations in a time unit.//Calculate an average running time per operation
                    .timeUnit(TimeUnit.MILLISECONDS)
                    .measurementTime(new TimeValue(5, TimeUnit.SECONDS))
                    .measurementIterations(5)
                    .build();

            new Runner(opt).run();
        }


        @Benchmark
        public void benchMark() throws InterruptedException {

            thread.start();
            thread.join();

        }
    }

    @State(Scope.Thread)
    @Warmup(iterations = 0)
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(time = 3)
    @Fork(1)
    public static class almostCpu {
        public static void main(String[] args) throws RunnerException {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Options opt = new OptionsBuilder().addProfiler("gc").addProfiler("stack")
                    .include(JmhTesting.almostCpu.class.getSimpleName())
                    .forks(2)
                    .mode(Mode.Throughput) //Calculate number of operations in a time unit.//Calculate an average running time per operation
                    .timeUnit(TimeUnit.MILLISECONDS)
                    .measurementTime(new TimeValue(3, TimeUnit.SECONDS))
                    .measurementIterations(3)
                    .build();

            new Runner(opt).run();
        }

        int i;

        @Setup
        public void Setup() {
            i = 0;
        }

        @Benchmark
        public void almostCpuTest(Blackhole bh) {
            while (i < 100) {
                i++;
            }
            bh.consume(i);
        }
    }
}
