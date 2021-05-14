package com.company.Utils;

import com.company.Tasks.BubbleSort;
import com.company.Tasks.TaskCreateFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InitIo {

    private static final int ARR_LENGTH = 500;
    private static final int ARR_NUM = 500;

    public static Input userIn(){
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        boolean modeTwo = false;
        int num;
        while (true){
            try{

                System.out.println("enter num of user (1-20000)");
                num = Integer.parseInt(scanner.nextLine());
                if (num < 1 || num > 20000){
                    throw new NumberFormatException();
                }
                input.setUserNum(num);

            }catch (NumberFormatException e){
                System.out.println("enter an Integer from 0 - 20000");
                continue;
            }
            break;
        }
        while (true){
            try {
                System.out.println("enter mode selection:\n" +
                        "1 : one user per thread\n" +
                        "2 : thread pool\n");
                num = Integer.parseInt(scanner.nextLine());
                if (num != 1 && num != 2){
                    throw new NumberFormatException();
                }
                if (num == 2){
                    modeTwo = true;
                }
            }catch (NumberFormatException e){
                System.out.println("input should be 1 or 2");
                continue;
            }
            input.setMode(num);
            break;
        }
        if (modeTwo){
            while (true){
                try {
                    System.out.println("enter an Integer from 0 - 10000 for thread pool size");
                    num = Integer.parseInt(scanner.nextLine());
                    if (num < 1 || num > 10000){
                        throw new NumberFormatException();
                    }
                    input.setPoolSize(num);
                }catch (NumberFormatException e){

                    continue;
                }
                break;
            }
        }else {
            input.setPoolSize(0);
        }
        while (true){
            try {
                System.out.println("select task:\n" +
                        "1 : bubble sort\n" +
                        "2 : generate random files\n");
                num = Integer.parseInt(scanner.nextLine());
                if (num != 1 && num != 2){
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                System.out.println("only input 1 or 2");
                continue;

            }
            if (num == 1){
                input.setRunner(new BubbleSort(ARR_LENGTH,ARR_NUM));
            }else {
                input.setRunner(new TaskCreateFile());
            }
            break;
        }
        return input;

    }

}
