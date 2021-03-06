package com.company.jmhtesting;

/**
 * looking for how many number between rep and rep * 2 can be perfected square rooted
 *
 * @author lekeping
 */
public class AlmostCpu implements Task {
    int input;

    public AlmostCpu(int input) {
        this.input = input;
    }

    @Override
    public int run() {
        int count = 0;
        for (int i = input; i < input * 10; i++) {
            int o = i;
            while (o > 0) {
                o--;
                if (o * o == i) {
                    count++;
                } else {
                    int p = o;
                    for (int l = 1; l < o; l++) {
                        if (p == i) {
                            count++;
                        }
                        p *= o - l;
                        p--;
                    }
                }
            }
        }
        return count;
    }
}
