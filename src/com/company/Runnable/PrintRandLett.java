package com.company.Runnable;

import com.company.Utils.HelperFunc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class PrintRandLett implements Runnable {
    private CountDownLatch countDownLatch;

    public PrintRandLett(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        Random random = new Random();
        String randString = HelperFunc.generateRandomString(random.nextInt(10) + 5);
        System.out.println(randString);
        countDownLatch.countDown();
    }
}
