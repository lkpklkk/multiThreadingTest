package com.company;

import com.company.jmhtesting.*;
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


@State(Scope.Benchmark)
public class TestNum1000Final {
    public static final int FIND_PERFECT_SQUARE_1000MS = 65900;
    public static final int FIND_PERFECT_SQUARE_500MS = 46590;
    public static final int DEFAULT_TEST_VALUE = 100;

    public static void main(String[] args) throws RunnerException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Options opt = new OptionsBuilder()
                .include(TestNum1000Final.class.getSimpleName())
                .warmupIterations(0)
                .warmupTime(TimeValue.seconds(5))
                .warmupForks(0)
                .forks(1)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .measurementTime(new TimeValue(3, TimeUnit.SECONDS))
                .measurementIterations(1)
                .build();

        new Runner(opt).run();
    }

    private ExecutorService executorService;
    private Runnable runnable;
    private Task task;
    @Param({"12", "16", "30", "20"})
    int threadNum;
    int taskNum = 50;
    @Param({"1", "2", "6"})
    int taskType;
    @Param({"0", "100", "300"})
    double waitPercentage;
    @Param({"false"})
    boolean isSingle;

    @Setup(Level.Invocation)
    public void setUp() {

        executorService = Executors.newFixedThreadPool(threadNum);
        switch (taskType) {
            case 1:
                //around 150 ms
                task = (new AlmostCpu(DEFAULT_TEST_VALUE));
                break;
            case 2:
                //around 200 ms
                task = (new AlmostIo(DEFAULT_TEST_VALUE));
                break;
            case 3:
                // around 150ms
                task = new InBetweenOri150ms(DEFAULT_TEST_VALUE, Math.round(150 * (waitPercentage / 100)));
                break;
            case 4:
                // around 10ms
                task = new InBetween10ms(DEFAULT_TEST_VALUE, Math.round(10 * (waitPercentage / 100)));
                break;
            case 5:
                //around 1000ms
                task = new FindPerfectSquareRoot(FIND_PERFECT_SQUARE_1000MS, Math.round(1000 * (waitPercentage / 100)));
                break;
            case 6:
                //around 500ms
                task = new FindPerfectSquareRoot(FIND_PERFECT_SQUARE_500MS, Math.round(500 * (waitPercentage / 100)));
                break;
            case 7:
                task = new FindPerfectSquareRoot(90800, Math.round(500 * (waitPercentage / 100)));
            default:
                break;
        }
        runnable = new RunnableTask(task);
    }

    @Benchmark
    public void test() throws InterruptedException {
        if (isSingle) {
            task.run();
        } else {
            for (int i = 0; i < taskNum; i++) {
                executorService.execute(runnable);
            }
            executorService.shutdown();
            executorService.awaitTermination(30, TimeUnit.MINUTES);
        }


    }
}



