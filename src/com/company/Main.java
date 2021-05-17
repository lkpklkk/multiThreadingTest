package com.company;

import com.company.Utils.InitIo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {



    public static void main(String[] args) {
	// write your code here

        Input input = InitIo.userIn();
        Runnable runner = input.getRunner();
        int mode = input.getMode();
        int num = input.getUserNum();
        switch (mode){
            default:System.out.println("mode invalid");
            case 1:

                for (int i = 0; i < num;i++){

                    Thread thread = new Thread(runner);
                    thread.start();
                }
                break;
            case 2:
                ExecutorService pool = Executors.newFixedThreadPool(input.getPoolSize());
                for (int i = 0; i < num;i++){
                    pool.execute(runner);
                }
                pool.shutdown();

                break;
        }


    }
}
