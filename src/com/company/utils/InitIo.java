package com.company.utils;

import com.company.Input;
import com.company.runnable.BubbleSort;
import com.company.runnable.PrintRandLett;
import com.company.runnable.SimpleAdd;
import com.company.runnable.CreateFiles;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class InitIo {

    private CountDownLatch countDownLatch;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }


    public Input userIn() {
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        boolean modeTwo = false;
        int num;
        while (true) {
            try {

                System.out.println("enter num of user (1-20000)");
                num = Integer.parseInt(scanner.nextLine());
                if (num < 1 || num > 20000) {
                    throw new NumberFormatException();
                }
                input.setUserNum(num);

            } catch (NumberFormatException e) {
                System.out.println("enter an Integer from 0 - 20000");
                continue;
            }
            break;
        }
        countDownLatch = new CountDownLatch(num);
        while (true) {
            try {
                System.out.println("enter mode selection:\n" +
                        "1 : one user per thread\n" +
                        "2 : thread pool\n");
                num = Integer.parseInt(scanner.nextLine());
                if (num != 1 && num != 2) {
                    throw new NumberFormatException();
                }
                if (num == 2) {
                    modeTwo = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("input should be 1 or 2");
                continue;
            }
            input.setMode(num);
            break;
        }
        if (modeTwo) {
            while (true) {
                try {
                    System.out.println("enter an Integer from 0 - 10000 for thread pool size");
                    num = Integer.parseInt(scanner.nextLine());
                    if (num < 1 || num > 10000) {
                        throw new NumberFormatException();
                    }
                    input.setPoolSize(num);
                } catch (NumberFormatException e) {

                    continue;
                }
                break;
            }
        } else {
            input.setPoolSize(0);
        }
        while (true) {
            try {
                System.out.println("select task:\n" +
                        "1 : bubble sort\n" +
                        "2 : generate random files\n" +
                        "3 : simple operation\n" +
                        "4 : print random string");
                num = Integer.parseInt(scanner.nextLine());
                if (num != 1 && num != 2 && num != 3 && num != 4) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("retry input");
                continue;

            }

            switch (num) {
                default:
                    break;
                case 1:
                    input.setRunner(new BubbleSort(countDownLatch));
                    break;
                case 2:
                    input.setRunner(new CreateFiles());
                    break;
                case 3:
                    input.setRunner(new SimpleAdd(countDownLatch));
                    break;
                case 4:
                    input.setRunner(new PrintRandLett(countDownLatch));
            }
            break;
        }
        return input;

    }

}
