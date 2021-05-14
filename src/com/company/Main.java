package com.company;

import com.company.Tasks.BubbleSort;
import com.company.Utils.InitIo;
import com.company.Utils.Input;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {



    public static void main(String[] args) {
	// write your code here

        Input input = InitIo.userIn();
        if (input.getMode() == 1){
            for (int i = 0; i < input.getUserNum();i++){
                Runnable runnable = input.getRunner();
                Thread thread = new Thread(runnable);
                thread.start();
            }

        }else if(input.getMode() == 2) {
            ExecutorService pool = Executors.newFixedThreadPool(input.getPoolSize());
            for (int i = 0; i < input.getUserNum();i++){
                Runnable runnable = input.getRunner();
                pool.execute(runnable);
            }

        }else {
            return;
        }


    }
}
