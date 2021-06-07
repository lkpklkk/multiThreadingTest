package com.company.jmhtesting;

public class AlmostIo implements Task {
    int rep;

    public AlmostIo(int rep) {
        this.rep = rep;
    }

    @Override
    public int run() throws InterruptedException {

        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep = Math.abs(rep) / 2;
            rep--;
        }
        Thread.sleep(1000);
        return rep - 1;

    }
}
