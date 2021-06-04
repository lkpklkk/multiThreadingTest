# Task :

BubbleSort()

```java
    public class BubbleSort implements Runnable {

    private static final int ARR_LENGTH = 30;
    private static final int ARR_NUM = 10;
    private final Random random = new Random();
    private int rep = 1;

    private ArrayList<Integer> createArr() {
        //creates random arr
    }

    private void bubbleSort(ArrayList<Integer> arr) {
        //bubble sorts arr
    }

    @Override
    public void run() {
        while (rep != 0) {
            for (int i = 0; i < ARR_NUM; i++) {
                ArrayList<Integer> list = createArr();
                bubbleSort(list);
            }
            rep--;
        }
    }
}
```

@Benchmark

# Using SingleThread

```java
public static class singleThreadAllCpu {
    private static final int taskNum = 500;
    Thread thread;

    @Setup(Level.Invocation)
    public void setUp() {
        thread = new Thread(new BubbleSort(taskNum));
    }

    @Benchmark
    public void benchMark() throws InterruptedException {
        thread.start();
        thread.join();
    }
}
```

        Result "com.company.JmhTesting.singleThreadAllCpu.benchMark":
        18.644 ±(99.9%) 0.112 ms/op [Average]
        (min, avg, max) = (18.551, 18.644, 18.755), stdev = 0.074
        CI (99.9%): [18.532, 18.756] (assumes normal distribution)

        ....[Thread state distributions]..........................
        66.7%         RUNNABLE
        33.3%         WAITING
        
        ....[Thread state: RUNNABLE]..............................
        33.4%  50.0% java.net.SocketInputStream.socketRead0
        28.2%  42.3% com.company.runnable.BubbleSort.bubbleSort
        2.5%   3.7% java.util.Random.next
        1.5%   2.3% com.company.runnable.BubbleSort.createArr
        0.7%   1.0% <stack is empty, everything is filtered?>
        0.3%   0.4% java.util.Random.nextInt
        0.1%   0.1% com.company.runnable.BubbleSort.run
        0.0%   0.0% java.lang.Object.wait
        0.0%   0.0% java.util.ArrayList.<init>
        0.0%   0.0% java.lang.Thread.isAlive
        
        ....[Thread state: WAITING]...............................
        33.3% 100.0% java.lang.Object.wait

# Using newFixedSizedThreadPool

```java
public static class expe1 {
    private ExecutorService executorService;
    private Runnable runnable;
    @Param({"1", "5", "6", "7", "10", "20", "100", "200"})
    int threadNum;
    int taskNum = 500;

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
```

> threadNum = { 1 , 5 , 6 , 7 , 10 , 20 , 100 , 200 }  
> local CPU core count = 6

## threadNum = 1

        Result "com.company.JmhTesting.expe1.test":
        18.675 ±(99.9%) 0.142 ms/op [Average]
        (min, avg, max) = (18.572, 18.675, 18.791), stdev = 0.094
        CI (99.9%): [18.533, 18.817] (assumes normal distribution)
        
        ....[Thread state distributions]..........................................
        66.9%         RUNNABLE
        33.1%         TIMED_WAITING
        
        ....[Thread state: RUNNABLE]..............................................
        33.4%  49.9% java.net.SocketInputStream.socketRead0
        15.3%  22.9% com.company.runnable.BubbleSort.bubbleSort
        14.8%  22.2% java.lang.Thread.isInterrupted
        1.2%   1.8% java.util.Random.next
        0.9%   1.3% com.company.runnable.BubbleSort.createArr
        0.7%   1.0% <stack is empty, everything is filtered?>
        0.2%   0.4% java.util.Random.nextInt
        0.1%   0.1% java.util.concurrent.locks.AbstractQueuedSynchronizer.release
        0.0%   0.1% java.util.AbstractCollection.isEmpty
        0.0%   0.0% java.security.AccessController.getStackAccessControlContext
        0.2%   0.4% <other>
        
        ....[Thread state: TIMED_WAITING].........................................
        33.1% 100.0% sun.misc.Unsafe.park

## threadNum = 5

        Result "com.company.JmhTesting.expe1.test":
          13.181 ±(99.9%) 0.114 ms/op [Average]
          (min, avg, max) = (13.076, 13.181, 13.298), stdev = 0.075
          CI (99.9%): [13.067, 13.295] (assumes normal distribution)
   
        ....[Thread state distributions]......................................
        85.4%         RUNNABLE
        14.1%         TIMED_WAITING
        0.5%         WAITING
        
        ....[Thread state: RUNNABLE]..........................................
        44.7%  52.4% com.company.runnable.BubbleSort.bubbleSort
        20.0%  23.5% java.util.Random.next
        14.6%  17.1% java.net.SocketInputStream.socketRead0
        2.4%   2.9% java.lang.Thread.isInterrupted
        1.8%   2.1% com.company.runnable.BubbleSort.createArr
        0.5%   0.6% <stack is empty, everything is filtered?>
        0.4%   0.5% java.util.Random.nextInt
        0.3%   0.3% java.security.AccessController.getStackAccessControlContext
        0.1%   0.1% sun.misc.Unsafe.unpark
        0.1%   0.1% java.lang.Thread.start0
        0.4%   0.4% <other>
        
        ....[Thread state: TIMED_WAITING].....................................
        14.1% 100.0% sun.misc.Unsafe.park
        
        ....[Thread state: WAITING]...........................................
        0.5% 100.0% sun.misc.Unsafe.park

## threadNum = 6

          Result "com.company.JmhTesting.expe1.test":
          13.345 ±(99.9%) 0.079 ms/op [Average]
          (min, avg, max) = (13.280, 13.345, 13.436), stdev = 0.052
          CI (99.9%): [13.266, 13.424] (assumes normal distribution)  
          ....[Thread state distributions].........................................
            79.7%         RUNNABLE
            18.2%         TIMED_WAITING
            2.0%         WAITING
            
            ....[Thread state: RUNNABLE]...........................................
            28.9%  36.2% com.company.runnable.BubbleSort.bubbleSort
            21.4%  26.9% java.net.SocketInputStream.socketRead0
            10.2%  12.8% java.util.Random.next
            5.6%   7.0% java.lang.Thread.isInterrupted
            3.2%   4.0% <stack is empty, everything is filtered?>
            2.4%   2.9% sun.misc.Unsafe.park
            1.8%   2.2% sun.misc.Unsafe.unpark
            1.1%   1.3% com.company.runnable.BubbleSort.createArr
            0.8%   1.1% java.security.AccessController.getStackAccessControlContext
            0.6%   0.8% java.lang.Object.<init>
            3.8%   4.8% <other>
            
            ....[Thread state: TIMED_WAITING]......................................
            18.2% 100.0% sun.misc.Unsafe.park
            
            ....[Thread state: WAITING]............................................
            2.0% 100.0% sun.misc.Unsafe.park

## threadNum = 7

        Result "com.company.JmhTesting.expe1.test":
        13.652 ±(99.9%) 0.182 ms/op [Average]
        (min, avg, max) = (13.485, 13.652, 13.893), stdev = 0.121
        CI (99.9%): [13.470, 13.835] (assumes normal distribution)

        ....[Thread state: RUNNABLE]............................................
        27.2%  38.5% com.company.runnable.BubbleSort.bubbleSort
        16.5%  23.4% java.net.SocketInputStream.socketRead0
        10.7%  15.2% java.util.Random.next
        5.0%   7.1% <stack is empty, everything is filtered?>
        4.4%   6.3% java.lang.Thread.isInterrupted
        1.2%   1.7% sun.misc.Unsafe.park
        1.1%   1.6% java.lang.Throwable.fillInStackTrace
        1.0%   1.5% com.company.runnable.BubbleSort.createArr
        0.6%   0.9% sun.misc.Unsafe.unpark
        0.5%   0.7% java.security.AccessController.getStackAccessControlContext
        2.2%   3.1% <other>
        
        ....[Thread state: TIMED_WAITING].......................................
        15.3% 100.0% sun.misc.Unsafe.park
        
        ....[Thread state: WAITING].............................................
        14.1% 100.0% sun.misc.Unsafe.park

## threadNum = 10

        Result "com.company.JmhTesting.expe1.test":
        14.231 ±(99.9%) 0.157 ms/op [Average]
        (min, avg, max) = (14.010, 14.231, 14.388), stdev = 0.104
        CI (99.9%): [14.073, 14.388] (assumes normal distribution)

        ....[Thread state distributions].......................................
        50.4%         RUNNABLE
        38.2%         WAITING
        11.4%         TIMED_WAITING
        
        ....[Thread state: RUNNABLE]...........................................
        18.0%  35.7% com.company.runnable.BubbleSort.bubbleSort
        12.3%  24.3% java.net.SocketInputStream.socketRead0
        7.2%  14.2% java.util.Random.next
        4.1%   8.2% java.lang.Thread.isInterrupted
        2.5%   4.9% <stack is empty, everything is filtered?>
        1.7%   3.4% java.lang.Throwable.fillInStackTrace
        1.4%   2.7% sun.misc.Unsafe.park
        0.7%   1.3% sun.misc.Unsafe.unpark
        0.6%   1.2% com.company.runnable.BubbleSort.createArr
        0.4%   0.8% java.security.AccessController.getStackAccessControlContext
        1.6%   3.2% <other>
        
        ....[Thread state: WAITING]............................................
        38.2% 100.0% sun.misc.Unsafe.park

        ....[Thread state: TIMED_WAITING]......................................
        11.4% 100.0% sun.misc.Unsafe.park

## threadNum = 20

        Result "com.company.JmhTesting.expe1.test":
        16.973 ±(99.9%) 0.116 ms/op [Average]
        (min, avg, max) = (16.851, 16.973, 17.121), stdev = 0.077
        CI (99.9%): [16.856, 17.089] (assumes normal distribution)

        ....[Thread state distributions].......................................
        70.3%         WAITING
        24.6%         RUNNABLE
        5.1%         TIMED_WAITING
        
        ....[Thread state: WAITING]............................................
        70.3% 100.0% sun.misc.Unsafe.park
        
        ....[Thread state: RUNNABLE]...........................................
        9.4%  38.3% com.company.runnable.BubbleSort.bubbleSort
        5.6%  22.7% java.net.SocketInputStream.socketRead0
        3.1%  12.7% java.util.Random.next
        2.0%   8.0% java.lang.Thread.isInterrupted
        1.5%   6.2% <stack is empty, everything is filtered?>
        0.9%   3.6% java.lang.Throwable.fillInStackTrace
        0.5%   2.2% sun.misc.Unsafe.park
        0.3%   1.3% java.security.AccessController.getStackAccessControlContext
        0.3%   1.2% sun.misc.Unsafe.unpark
        0.3%   1.1% com.company.runnable.BubbleSort.createArr
        0.7%   2.7% <other>
        
        ....[Thread state: TIMED_WAITING]......................................
        5.1% 100.0% sun.misc.Unsafe.park

## threadNum = 100

        Result "com.company.JmhTesting.expe1.test":
        20.969 ±(99.9%) 0.187 ms/op [Average]
        (min, avg, max) = (20.738, 20.969, 21.124), stdev = 0.124
        CI (99.9%): [20.782, 21.156] (assumes normal distribution)

        ....[Thread state distributions].......................................
        94.2%         WAITING
        4.9%         RUNNABLE
        0.9%         TIMED_WAITING
        
        ....[Thread state: WAITING]............................................
        94.2% 100.0% sun.misc.Unsafe.park
        
        ....[Thread state: RUNNABLE]...........................................
        1.5%  30.6% com.company.runnable.BubbleSort.bubbleSort
        1.2%  25.1% java.net.SocketInputStream.socketRead0
        0.6%  12.4% <stack is empty, everything is filtered?>
        0.4%   8.7% java.util.Random.next
        0.4%   8.0% java.lang.Thread.isInterrupted
        0.3%   5.3% java.security.AccessController.getStackAccessControlContext
        0.1%   2.3% java.lang.Throwable.fillInStackTrace
        0.1%   2.1% sun.misc.Unsafe.park
        0.1%   1.2% sun.misc.Unsafe.unpark
        0.1%   1.1% com.company.runnable.BubbleSort.createArr
        0.2%   3.2% <other>
        
        ....[Thread state: TIMED_WAITING]......................................
        0.9% 100.0% sun.misc.Unsafe.park

## threadNum = 200

        Result "com.company.JmhTesting.expe1.test":
        24.983 ±(99.9%) 0.907 ms/op [Average]
        (min, avg, max) = (24.494, 24.983, 26.379), stdev = 0.600
        CI (99.9%): [24.076, 25.890] (assumes normal distribution)

        ....[Thread state distributions].......................................
        97.1%         WAITING
        2.5%         RUNNABLE
        0.4%         TIMED_WAITING
        
        ....[Thread state: WAITING]............................................
        97.1% 100.0% sun.misc.Unsafe.park
        
        ....[Thread state: RUNNABLE]...........................................
        0.7%  27.7% java.net.SocketInputStream.socketRead0
        0.5%  19.8% com.company.runnable.BubbleSort.bubbleSort
        0.5%  18.8% <stack is empty, everything is filtered?>
        0.3%   9.9% java.security.AccessController.getStackAccessControlContext
        0.2%   8.2% java.lang.Thread.isInterrupted
        0.1%   4.8% java.util.Random.next
        0.1%   2.5% sun.misc.Unsafe.park
        0.1%   2.2% java.lang.Throwable.fillInStackTrace
        0.0%   1.9% java.lang.Thread.start0
        0.0%   1.4% sun.misc.Unsafe.unpark
        0.1%   2.9% <other>
        
        ....[Thread state: TIMED_WAITING]......................................
        0.4% 100.0% sun.misc.Unsafe.park

## Summary

        Benchmark                     (threadNum)  Mode  Cnt   Score   Error  Units
        JmhTesting.expe1.test                   5  avgt   10  13.181 ± 0.114  ms/op
        JmhTesting.expe1.test                   6  avgt   10  13.345 ± 0.079  ms/op
        JmhTesting.expe1.test                   7  avgt   10  13.652 ± 0.182  ms/op
        JmhTesting.expe1.test                  10  avgt   10  14.231 ± 0.157  ms/op
        JmhTesting.expe1.test                  20  avgt   10  16.973 ± 0.116  ms/op
        JmhTesting.expe1.test                 100  avgt   10  20.969 ± 0.187  ms/op
        JmhTesting.expe1.test                 200  avgt   10  24.983 ± 0.907  ms/op
        