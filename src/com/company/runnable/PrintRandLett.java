package com.company.runnable;

import com.company.utils.Generator;

import java.util.Random;
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
        Random random = new Random();
        String randString = Generator.generateRandomString(random.nextInt(10) + 5);
        System.out.println(randString);
        countDownLatch.countDown();
    }
}
