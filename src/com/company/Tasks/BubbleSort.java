package com.company.Tasks;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort implements Runnable{
    private int arrSize;
    private int arrNum;
    private Random random;
    public BubbleSort(int arrSize, int arrNum) {
        this.arrSize = arrSize;
        this.arrNum = arrNum;
        this.random = new Random();
    }
    private ArrayList<Integer> createArr(){
        int size = random.nextInt(arrSize)+1;
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
    }

    @Override
    public void run() {
        for (int i = 0; i < arrNum;i ++){
            ArrayList<Integer> list = createArr();
            bubblesort(list);
        }
    }
}
