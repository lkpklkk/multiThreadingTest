package com.company.jmhtesting;

public class InBetweenOri150ms implements Task {
    int input;
    private final long waitTimeMili;

    public InBetweenOri150ms(int input, long waitTimeMili) {
        this.input = input;
        this.waitTimeMili = waitTimeMili;
    }

    @Override
    public int run() throws InterruptedException {
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
        Thread.sleep(waitTimeMili);
        return count;
    }
}
