package com.company.jmhtesting;

/**
 * @author lekeping
 */
public class AlmostIo implements Task {
    int rep;

    public AlmostIo(int rep) {
        this.rep = rep;
    }


    @Override
    public int run() throws InterruptedException {
        Thread.sleep(500);
        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep = Math.abs(rep) / 2;
            rep--;

        }
        return rep - 1;

    }
}
