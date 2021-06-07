package com.company.jmhtesting;

import java.util.ArrayList;
import java.util.Random;

public class Tasks {
    private static final int ARR_LENGTH = 30;
    private static final int ARR_NUM = 10;

    public static int almostCpu(int rep) {
        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep--;
        }
        return rep - 1;
    }

    public static int halfHalf(int rep) throws InterruptedException {
        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep--;
            Thread.sleep(10);
        }
        return rep - 1;
    }

    private static ArrayList<Integer> createArr() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>(ARR_LENGTH);
        for (int i = 0; i < ARR_LENGTH; i++) {
            list.add(random.nextInt(ARR_LENGTH) + 1);
        }
        return list;
    }

    private static void actualBubbleSort(ArrayList<Integer> arr) {
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

    public static int bubbleSort(int rep) {
        ArrayList<Integer> list = null;
        while (rep != 0) {
            for (int i = 0; i < ARR_NUM; i++) {
                list = createArr();
                actualBubbleSort(list);
            }
            rep--;
        }
        return list == null ? 0 : list.get(0);
    }

    public static int almostIo(int rep) throws InterruptedException {
        Thread.sleep(100);
        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep = rep / 2;
            rep--;
            Thread.sleep(1000);
        }
        return rep - 1;
    }


}
