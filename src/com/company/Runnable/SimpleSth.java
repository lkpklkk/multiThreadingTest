package com.company.Runnable;

import java.util.Random;

public class SimpleSth implements Runnable{
    Random random;
    public SimpleSth() {
        this.random = new Random();
    }

    @Override
    public void run() {
        int a,b,c;
        a = random.nextInt(11);
        b = random.nextInt(20);
        c = a * b;
        System.out.println(c + " \n");
    }
}
