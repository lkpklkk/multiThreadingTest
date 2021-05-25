package com.company.runnable;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author lekeping
 */
public class SimpleAdd implements Runnable {
    private final CountDownLatch latch;
    Random random;

    public SimpleAdd(CountDownLatch latch) {
        this.random = new Random();
        this.latch = latch;
    }

    @Override
    public void run() {
        int a, b, c;
        a = random.nextInt(11);
        b = random.nextInt(20);
        c = a * b;
        System.out.println(c + " \n");
        latch.countDown();
    }
}
