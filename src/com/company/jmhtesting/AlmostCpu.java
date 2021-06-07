package com.company.jmhtesting;

public class AlmostCpu implements Task {
    int rep;

    public AlmostCpu(int rep) {
        this.rep = rep;
    }

    @Override
    public int run() {
        if (rep < 0) {
            return rep;
        }
        while (rep > 0) {
            rep--;
        }
        return rep - 1;
    }
}
