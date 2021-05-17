package com.company.Runnable;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author lekeping
 */
public class BubbleSort implements Runnable{
    private static final int ARR_LENGTH = 500 ;
    private static final int ARR_NUM = 500;
    private Random random;
    public BubbleSort() {
        this.random = new Random();
    }
    private ArrayList<Integer> createArr(){
        int size = random.nextInt(ARR_LENGTH)+1;
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0;i < size;i++){
            list.add(random.nextInt(size)+1);
        }
        return list;
    }
    private void bubblesort(ArrayList<Integer> arr){
        int n = arr.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr.get(j) > arr.get(j + 1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }}}
        System.out.println("ok\n");
    }

    @Override
    public void run() {
        for (int i = 0; i < ARR_NUM;i ++){
            ArrayList<Integer> list = createArr();
            bubblesort(list);
        }
    }
}
