package com.company.jmhtesting;

/**
 * @author lekeping
 */
public class InBetween implements Task {
    int rep;

    public InBetween(int rep) {
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
        Thread.sleep(100);
        return rep - 1;

    }
}
