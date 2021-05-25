package com.company.runnable;

import com.company.utils.Generator;

import java.util.concurrent.CountDownLatch;

/**
 * @author lekeping
 */
public class PrintRandLett implements Runnable {
    private final CountDownLatch countDownLatch;

    public PrintRandLett(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        String randString = Generator.generateRandomString();
        System.out.println(randString);
        countDownLatch.countDown();
    }
}
