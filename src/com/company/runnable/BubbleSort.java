package com.company.runnable;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author lekeping
 */
public class BubbleSort implements Runnable {

    private static final int ARR_LENGTH = 30;
    private static final int ARR_NUM = 10;
    private final Random random = new Random();
    private int rep = 1;
    CountDownLatch latch;

    public BubbleSort(CountDownLatch latch) {
        this.latch = latch;
    }

    public BubbleSort(int rep) {
        this.rep = rep;
    }

    public BubbleSort() {
        this.latch = null;

    }


    private ArrayList<Integer> createArr() {
        ArrayList<Integer> list = new ArrayList<>(ARR_LENGTH);
        for (int i = 0; i < ARR_LENGTH; i++) {
            list.add(random.nextInt(ARR_LENGTH) + 1);
        }
        return list;
    }

    private void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void run() {
        while (rep != 0) {
            for (int i = 0; i < ARR_NUM; i++) {
                ArrayList<Integer> list = createArr();
                bubbleSort(list);
            }
            if (latch != null) {
                latch.countDown();
            }
            rep--;
        }


    }
}
