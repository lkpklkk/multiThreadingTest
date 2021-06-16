## Parameters: (taskType = 1, threadNum = 3)

....[Thread state distributions].................................................................... 79.8% RUNNABLE
20.2% TIMED_WAITING

....[Thread state: RUNNABLE]........................................................................ 59.5% 74.6%
com.company.jmhtesting.AlmostCpu.run 20.2% 25.3% java.net.SocketInputStream.socketRead0 0.0% 0.0% <stack is empty,
everything is filtered?>
0.0% 0.0% java.lang.Thread.currentThread 0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0%
java.util.concurrent.ThreadPoolExecutor.getTask 0.0% 0.0% sun.misc.Unsafe.getIntVolatile 0.0% 0.0%
java.util.concurrent.ThreadPoolExecutor.processWorkerExit

....[Thread state: TIMED_WAITING]................................................................... 20.2% 100.0%
sun.misc.Unsafe.park

## Parameters: (taskType = 1, threadNum = 6)

Iteration 1: 2.587 s/op ·stack: <delayed till summary>

Iteration 2: 2.591 s/op ·stack: <delayed till summary>

2.589 s/op

....[Thread state distributions].................................................................... 87.0% RUNNABLE
13.0% TIMED_WAITING

....[Thread state: RUNNABLE]........................................................................ 73.9% 84.9%
com.company.jmhtesting.AlmostCpu.run 13.1% 15.0% java.net.SocketInputStream.socketRead0 0.0% 0.0% <stack is empty,
everything is filtered?>
0.0% 0.0% java.util.concurrent.TimeUnit.x 0.0% 0.0% java.util.concurrent.ThreadPoolExecutor.workerCountOf 0.0% 0.0%
sun.misc.Unsafe.compareAndSwapInt

....[Thread state: TIMED_WAITING]................................................................... 13.0% 100.0%
sun.misc.Unsafe.park

## Parameters: (taskType = 1, threadNum = 12)

Iteration 1: 2.588 s/op ·stack: <delayed till summary>

Iteration 2: 2.581 s/op ·stack: <delayed till summary>

2.585 s/op

        ....[Thread state distributions].................................................................... 92.1% RUNNABLE 7.8%
        TIMED_WAITING
        
        ....[Thread state: RUNNABLE]........................................................................ 82.8% 89.8%
        com.company.jmhtesting.AlmostCpu.run 8.2% 8.9% java.net.SocketInputStream.socketRead0 0.9% 0.9% <stack is empty,
        everything is filtered?>
        0.2% 0.2% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0% java.lang.Thread.currentThread 0.0% 0.0%
        java.security.AccessController.getStackAccessControlContext 0.0% 0.0%
        java.util.concurrent.locks.ReentrantLock$Sync.tryRelease
        
        ....[Thread state: TIMED_WAITING]................................................................... 7.8% 100.0%
        sun.misc.Unsafe.park

## Parameters: (taskType = 1, threadNum = 24)

Iteration 1: 2.569 s/op ·stack: <delayed till summary>

Iteration 2: 2.562 s/op ·stack: <delayed till summary>

2.566 s/op

        ....[Thread state distributions].................................................................... 93.8% RUNNABLE 4.5%
        TIMED_WAITING 1.7% WAITING
        
        ....[Thread state: RUNNABLE]........................................................................ 85.5% 91.1%
        com.company.jmhtesting.AlmostCpu.run 4.9% 5.2% java.net.SocketInputStream.socketRead0 2.8% 3.0% <stack is empty,
        everything is filtered?>
        0.3% 0.3% sun.misc.Unsafe.compareAndSwapInt 0.1% 0.1% java.lang.Thread.currentThread 0.1% 0.1%
        java.lang.Throwable.fillInStackTrace 0.1% 0.1% java.lang.Thread.setPriority0 0.0% 0.1% sun.misc.Unsafe.getIntVolatile
        0.0% 0.1% java.lang.Thread.interrupt 0.0% 0.0% sun.misc.Unsafe.unpark
        
        ....[Thread state: TIMED_WAITING]................................................................... 4.5% 100.0%
        sun.misc.Unsafe.park
        
        ....[Thread state: WAITING]......................................................................... 1.7% 100.0%
        sun.misc.Unsafe.park

## Parameters: (taskType = 1, threadNum = 48)

Iteration 1: 2.600 s/op ·stack: <delayed till summary>

Iteration 2: 2.591 s/op ·stack: <delayed till summary>

2.596 s/op

        ....[Thread state distributions].................................................................... 97.1% RUNNABLE 2.8%
        TIMED_WAITING 0.2% WAITING
        
        ....[Thread state: RUNNABLE]........................................................................ 81.0% 83.5%
        com.company.jmhtesting.AlmostCpu.run 12.8% 13.2% <stack is empty, everything is filtered?>
        3.0% 3.0% java.net.SocketInputStream.socketRead0 0.1% 0.1% sun.misc.Unsafe.compareAndSwapInt 0.1% 0.1%
        java.lang.Thread.currentThread 0.0% 0.0% java.util.concurrent.locks.AbstractOwnableSynchronizer.setExclusiveOwnerThread
        0.0% 0.0% sun.misc.Unsafe.getIntVolatile 0.0% 0.0% java.util.AbstractCollection.isEmpty 0.0% 0.0%
        java.lang.Thread.start0
        
        ....[Thread state: TIMED_WAITING]................................................................... 2.8% 100.0%
        sun.misc.Unsafe.park
        
        ....[Thread state: WAITING]......................................................................... 0.2% 100.0%
        sun.misc.Unsafe.park

## Parameters: (taskType = 1, threadNum = 96)

Iteration 1: 2.592 s/op ·stack: <delayed till summary>

Iteration 2: 2.572 s/op ·stack: <delayed till summary>

2.582 s/op

        ....[Thread state distributions].................................................................... 94.8% RUNNABLE 3.7%
        WAITING 1.4% TIMED_WAITING
        
        ....[Thread state: RUNNABLE]........................................................................ 71.3% 75.2%
        com.company.jmhtesting.AlmostCpu.run 21.2% 22.4% <stack is empty, everything is filtered?>
        1.6% 1.7% java.net.SocketInputStream.socketRead0 0.4% 0.4% java.lang.Thread.currentThread 0.2% 0.2%
        sun.misc.Unsafe.compareAndSwapInt 0.1% 0.1% java.lang.Thread.isInterrupted 0.0% 0.0% java.lang.Thread.isAlive 0.0% 0.0%
        java.security.AccessController.getStackAccessControlContext 0.0% 0.0% java.lang.Thread.interrupt 0.0% 0.0%
        sun.misc.Unsafe.getIntVolatile
        
        ....[Thread state: WAITING]......................................................................... 3.7% 100.0%
        sun.misc.Unsafe.park
        
        ....[Thread state: TIMED_WAITING]................................................................... 1.4% 100.0%
        sun.misc.Unsafe.park

## Parameters: (taskType = 2, threadNum = 3)

Iteration 1: 34.083 s/op ·stack: <delayed till summary>

Iteration 2: 34.083 s/op ·stack: <delayed till summary>

34.083 s/op ....[Thread state distributions].................................................................... 79.4%
TIMED_WAITING 20.6% RUNNABLE

        ....[Thread state: TIMED_WAITING]................................................................... 59.2% 74.5%
        java.lang.Thread.sleep 20.2% 25.5% sun.misc.Unsafe.park
        
        ....[Thread state: RUNNABLE]........................................................................ 20.2% 98.4%
        java.net.SocketInputStream.socketRead0 0.1% 0.6% java.lang.Thread.currentThread 0.1% 0.3%
        sun.misc.Unsafe.compareAndSwapInt 0.0% 0.1% java.lang.Thread.isInterrupted 0.0% 0.1% sun.misc.Unsafe.getIntVolatile 0.0%
        0.1% java.lang.Thread.sleep 0.0% 0.1% sun.misc.Unsafe.compareAndSwapObject 0.0% 0.1% com.company.jmhtesting.AlmostIo.run
        0.0% 0.0% <stack is empty, everything is filtered?>
        0.0% 0.0% java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.signalAll 0.0% 0.2% <other>

## Parameters: (taskType = 2, threadNum = 6)

Iteration 1: 17.048 s/op ·stack: <delayed till summary>

Iteration 2: 17.050 s/op ·stack: <delayed till summary>

17.049 s/op

        ....[Thread state distributions].................................................................... 86.3% TIMED_WAITING
        13.0% RUNNABLE 0.8% WAITING
        
        ....[Thread state: TIMED_WAITING]................................................................... 73.7% 85.4%
        java.lang.Thread.sleep 12.6% 14.6% sun.misc.Unsafe.park
        
        ....[Thread state: RUNNABLE]........................................................................ 12.6% 97.2%
        java.net.SocketInputStream.socketRead0 0.2% 1.3% java.lang.Thread.currentThread 0.0% 0.3%
        sun.misc.Unsafe.compareAndSwapInt 0.0% 0.1% sun.misc.Unsafe.getIntVolatile 0.0% 0.1%
        java.util.AbstractCollection.isEmpty 0.0% 0.1% java.lang.Thread.sleep 0.0% 0.1% sun.misc.Unsafe.compareAndSwapObject
        0.0% 0.1% java.lang.Thread.isInterrupted 0.0% 0.1% java.util.concurrent.ThreadPoolExecutor.getTask 0.0% 0.1% <stack is
        empty, everything is filtered?>
        0.1% 0.4% <other>
        
        ....[Thread state: WAITING]......................................................................... 0.8% 100.0%
        sun.misc.Unsafe.park

## Parameters: (taskType = 2, threadNum = 12)

Iteration 1: 9.028 s/op ·stack: <delayed till summary>

Iteration 2: 9.022 s/op ·stack: <delayed till summary>

9.025 s/op

    ....[Thread state distributions].................................................................... 89.7% TIMED_WAITING
    7.8% RUNNABLE 2.5% WAITING
    
    ....[Thread state: TIMED_WAITING]................................................................... 82.3% 91.7%
    java.lang.Thread.sleep 7.4% 8.3% sun.misc.Unsafe.park
    
    ....[Thread state: RUNNABLE]........................................................................ 7.4% 95.8%
    java.net.SocketInputStream.socketRead0 0.1% 1.8% java.lang.Thread.currentThread 0.0% 0.6%
    sun.misc.Unsafe.compareAndSwapInt 0.0% 0.3% sun.misc.Unsafe.getIntVolatile 0.0% 0.2% java.lang.Thread.isInterrupted 0.0%
    0.2% sun.misc.Unsafe.compareAndSwapObject 0.0% 0.2% sun.misc.Unsafe.unpark 0.0% 0.1% <stack is empty, everything is
    filtered?>
    0.0% 0.1% java.lang.Thread.sleep 0.0% 0.1% java.util.concurrent.ThreadPoolExecutor.getTask 0.0% 0.6% <other>
    
    ....[Thread state: WAITING]......................................................................... 2.5% 100.0%
    sun.misc.Unsafe.park

## Parameters: (taskType = 2, threadNum = 24)

Iteration 1: 5.013 s/op ·stack: <delayed till summary>

Iteration 2: 5.014 s/op ·stack: <delayed till summary>

5.013 s/op

    ....[Thread state distributions].................................................................... 93.4% TIMED_WAITING
    4.7% RUNNABLE 1.9% WAITING
    
    ....[Thread state: TIMED_WAITING]................................................................... 89.0% 95.2%
    java.lang.Thread.sleep 4.5% 4.8% sun.misc.Unsafe.park
    
    ....[Thread state: RUNNABLE]........................................................................ 4.5% 94.7%
    java.net.SocketInputStream.socketRead0 0.1% 1.7% java.lang.Thread.currentThread 0.0% 1.0%
    sun.misc.Unsafe.compareAndSwapInt 0.0% 0.3% sun.misc.Unsafe.getIntVolatile 0.0% 0.3% <stack is empty, everything is
    filtered?>
    0.0% 0.3% sun.misc.Unsafe.compareAndSwapObject 0.0% 0.2% sun.misc.Unsafe.park 0.0% 0.2% sun.misc.Unsafe.putObject 0.0%
    0.2% java.util.concurrent.ThreadPoolExecutor.getTask 0.0% 0.1% java.util.concurrent.ThreadPoolExecutor.runWorker 0.0%
    0.9% <other>
    
    ....[Thread state: WAITING]......................................................................... 1.9% 100.0%
    sun.misc.Unsafe.park

## Parameters: (taskType = 2, threadNum = 48)

Iteration 1: 3.005 s/op ·stack: <delayed till summary>

Iteration 2: 3.013 s/op ·stack: <delayed till summary>

3.009 s/op

    ....[Thread state distributions].................................................................... 94.2% TIMED_WAITING
    3.0% RUNNABLE 2.9% WAITING
    
    ....[Thread state: TIMED_WAITING]................................................................... 91.4% 97.1%
    java.lang.Thread.sleep 2.7% 2.9% sun.misc.Unsafe.park
    
    ....[Thread state: RUNNABLE]........................................................................ 2.8% 92.9%
    java.net.SocketInputStream.socketRead0 0.1% 2.1% java.lang.Thread.currentThread 0.0% 1.2%
    sun.misc.Unsafe.compareAndSwapInt 0.0% 0.8% <stack is empty, everything is filtered?>
    0.0% 0.4% sun.misc.Unsafe.compareAndSwapObject 0.0% 0.3% java.lang.Thread.isInterrupted 0.0% 0.3%
    java.util.concurrent.ThreadPoolExecutor.getTask 0.0% 0.2% sun.misc.Unsafe.getIntVolatile 0.0% 0.2%
    java.util.concurrent.LinkedBlockingQueue.take 0.0% 0.2% java.security.AccessController.getStackAccessControlContext 0.0%
    1.5% <other>
    
    ....[Thread state: WAITING]......................................................................... 2.9% 100.0%
    sun.misc.Unsafe.park

## Parameters: (taskType = 2, threadNum = 96)

Iteration 1: 2.004 s/op ·stack: <delayed till summary>

Iteration 2: 2.008 s/op ·stack: <delayed till summary>

2.006 s/op

    ....[Thread state distributions].................................................................... 94.6% TIMED_WAITING
    3.3% WAITING 2.1% RUNNABLE
    
    ....[Thread state: TIMED_WAITING]................................................................... 92.8% 98.1%
    java.lang.Thread.sleep 1.8% 1.9% sun.misc.Unsafe.park
    
    ....[Thread state: WAITING]......................................................................... 3.3% 100.0%
    sun.misc.Unsafe.park
    
    ....[Thread state: RUNNABLE]........................................................................ 1.9% 90.1%
    java.net.SocketInputStream.socketRead0 0.0% 2.2% <stack is empty, everything is filtered?>
    0.0% 1.9% java.lang.Thread.currentThread 0.0% 1.7% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.5%
    java.lang.Thread.isInterrupted 0.0% 0.4% sun.misc.Unsafe.getIntVolatile 0.0% 0.3%
    java.security.AccessController.getStackAccessControlContext 0.0% 0.3% java.lang.Thread.setPriority0 0.0% 0.2%
    sun.misc.Unsafe.putObject 0.0% 0.2% sun.misc.Unsafe.compareAndSwapObject 0.0% 2.3% <other>

## Parameters: (taskType = 3, threadNum = 3)

Iteration 1: 9.691 s/op ·stack: <delayed till summary>

Iteration 2: 9.673 s/op ·stack: <delayed till summary>

9.682 s/op

    ....[Thread state distributions].................................................................... 60.7% RUNNABLE
    39.3% TIMED_WAITING
    
    ....[Thread state: RUNNABLE]........................................................................ 40.4% 66.6%
    com.company.jmhtesting.InBetween10ms.run 20.3% 33.4% java.net.SocketInputStream.socketRead0 0.0% 0.0% java.lang.Thread.sleep
    0.0% 0.0% <stack is empty, everything is filtered?>
    0.0% 0.0% java.lang.Thread.currentThread 0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0%
    com.company.jmhtesting.RunnableTask.run
    
    ....[Thread state: TIMED_WAITING]................................................................... 20.2% 51.5%
    sun.misc.Unsafe.park 19.1%   
    48.5% java.lang.Thread.sleep

## Parameters: (taskType = 3, threadNum = 6)

Iteration 1: 4.820 s/op ·stack: <delayed till summary>

Iteration 2: 4.827 s/op ·stack: <delayed till summary>

4.823 s/op

    ....[Thread state distributions].................................................................... 56.5% TIMED_WAITING
    43.5% RUNNABLE
    
    ....[Thread state: TIMED_WAITING]................................................................... 43.6% 77.3%
    java.lang.Thread.sleep 12.8% 22.7% sun.misc.Unsafe.park
    
    ....[Thread state: RUNNABLE]........................................................................ 30.6% 70.3%
    com.company.jmhtesting.InBetween10ms.run 12.8% 29.5% java.net.SocketInputStream.socketRead0 0.0% 0.1% java.lang.Thread.sleep
    0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0% <stack is empty, everything is filtered?>
    0.0% 0.0% java.lang.Thread.currentThread 0.0% 0.0%
    java.util.concurrent.locks.AbstractOwnableSynchronizer.getExclusiveOwnerThread

## Parameters: (taskType = 3, threadNum = 12)

## Run progress: 77.78% complete, ETA 00:01:55

## Fork: 1 of 1

Iteration 1: 2.831 s/op ·stack: <delayed till summary>

Iteration 2: 2.768 s/op ·stack: <delayed till summary>

2.800 s/op

....[Thread state distributions].................................................................... 52.7% RUNNABLE
47.3% TIMED_WAITING

....[Thread state: RUNNABLE]........................................................................ 44.9% 85.1%
com.company.jmhtesting.InBetween10ms.run 7.7% 14.7% java.net.SocketInputStream.socketRead0 0.0% 0.1%
java.lang.Thread.sleep 0.0% 0.1% <stack is empty, everything is filtered?>
0.0% 0.0% java.lang.Thread.isInterrupted 0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0%
sun.misc.Unsafe.compareAndSwapLong 0.0% 0.0% com.company.jmhtesting.RunnableTask.run

....[Thread state: TIMED_WAITING]................................................................... 39.6% 83.7%
java.lang.Thread.sleep 7.7% 16.3% sun.misc.Unsafe.park

## Parameters: (taskType = 3, threadNum = 24)

## Run progress: 83.33% complete, ETA 00:01:25

## Fork: 1 of 1

Iteration 1: 2.695 s/op ·stack: <delayed till summary>

Iteration 2: 2.687 s/op ·stack: <delayed till summary>

2.691 s/op

....[Thread state distributions].................................................................... 58.6% RUNNABLE
41.4% TIMED_WAITING

....[Thread state: RUNNABLE]........................................................................ 54.1% 92.3%
com.company.jmhtesting.InBetween10ms.run 4.4% 7.5% java.net.SocketInputStream.socketRead0 0.0% 0.1% <stack is empty,
everything is filtered?>
0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0% java.lang.Thread.sleep 0.0% 0.0% sun.misc.Unsafe.getIntVolatile

....[Thread state: TIMED_WAITING]................................................................... 37.0% 89.4%
java.lang.Thread.sleep 4.4% 10.6% sun.misc.Unsafe.park

## Parameters: (taskType = 3, threadNum = 48)

## Run progress: 88.89% complete, ETA 00:00:56

## Fork: 1 of 1

Iteration 1: 2.696 s/op ·stack: <delayed till summary>

Iteration 2: 2.689 s/op ·stack: <delayed till summary>

2.693 s/op

....[Thread state distributions].................................................................... 59.9% RUNNABLE
40.1% TIMED_WAITING

....[Thread state: RUNNABLE]........................................................................ 57.2% 95.5%
com.company.jmhtesting.InBetween10ms.run 2.5% 4.2% java.net.SocketInputStream.socketRead0 0.1% 0.2%
java.lang.Thread.sleep 0.0% 0.1% <stack is empty, everything is filtered?>
0.0% 0.0% sun.misc.Unsafe.compareAndSwapInt 0.0% 0.0% sun.misc.Unsafe.unpark

....[Thread state: TIMED_WAITING]................................................................... 37.7% 93.9%
java.lang.Thread.sleep 2.5% 6.1% sun.misc.Unsafe.park

## Parameters: (taskType = 3, threadNum = 96)

....[Thread state distributions].................................................................... 65.9% TIMED_WAITING
34.1% RUNNABLE

....[Thread state: TIMED_WAITING]................................................................... 64.4% 97.7%
java.lang.Thread.sleep 1.5% 2.3% sun.misc.Unsafe.park

....[Thread state: RUNNABLE]........................................................................ 32.5% 95.2%
com.company.jmhtesting.InBetween10ms.run 1.5% 4.5% java.net.SocketInputStream.socketRead0 0.0% 0.1% <stack is empty,
everything is filtered?>
0.0% 0.1% java.lang.Thread.sleep 0.0% 0.0% java.security.AccessController.getStackAccessControlContext 0.0% 0.0%
sun.misc.Unsafe.compareAndSwapInt

## Run Summary. Total time: 00:08:12

taskType|  threadNum| Score (s/op) |
| ----------- | ----------- | ----------- |
cpu|  3 |5.125
cpu|  **6** |2.589
cpu|  12| 2.585
cpu|  24|2.566
cpu|  48|2.596
cpu|  96|2.582
IO | 3 |34.083
IO | 6 |17.049
IO | 12 |9.025
IO | 24| 5.013
IO | 48| 3.009
IO | **96**| 2.006
InBe| 3 |9.682
InBe| 6 |4.823
InBe| **12** |2.800
InBe| 24 |2.691
InBe| 48 |2.693
InBe| 96 |2.683

Process finished with exit code 0
