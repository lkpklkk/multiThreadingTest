package com.company.jmhtesting;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort implements Task {
    int rep;
    private static final int ARR_LENGTH = 30;
    private static final int ARR_NUM = 10;
    private final Random random = new Random();

    public BubbleSort(int rep) {
        this.rep = rep;
    }

    @Override
    public int run() throws InterruptedException {
        ArrayList<Integer> list = null;
        while (rep != 0) {
            for (int i = 0; i < ARR_NUM; i++) {
                list = createArr();
                bubbleSort(list);
            }
            rep--;
        }
        return list == null ? -1 : list.get(0);
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
}
