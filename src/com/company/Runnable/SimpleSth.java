package com.company.Runnable;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class SimpleSth implements Runnable{
    private final CountDownLatch latch;
    Random random;
    public SimpleSth(CountDownLatch latch) {
        this.random = new Random();
        this.latch = latch;
    }

    @Override
    public void run() {
        int a,b,c;
        a = random.nextInt(11);
        b = random.nextInt(20);
        c = a * b;
        System.out.println(c + " \n");
        latch.countDown();
    }
}
