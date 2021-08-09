package com.company.jmhtesting;

public class FindPerfectSquareRoot implements Task {
    private final int num;
    private final long waitTimeMili;

    public FindPerfectSquareRoot(int num, long waitTimeMili) {
        this.num = num;
        this.waitTimeMili = waitTimeMili;
    }

    @Override
    public int run() throws InterruptedException {
        int count = 0;
        for (int i = 0; i < num; i++) {
            for (int o = 0; o <= i; o++) {
                if (o * o == i) {
                    count++;
                }
            }
        }
        Thread.sleep(waitTimeMili);
        return count;
    }
}
