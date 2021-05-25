package com.company.runnable;

import com.company.utils.Generator;

import java.util.concurrent.CountDownLatch;

/**
 * @author lekeping
 */
public class PrintRandStr implements Runnable {
    private final CountDownLatch countDownLatch;

    public PrintRandStr(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        String randString = Generator.generateRandomString();
        System.out.println(randString);
        countDownLatch.countDown();
    }
}
