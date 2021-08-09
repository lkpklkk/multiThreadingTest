package com.company.jmhtesting;

/**
 * @author lekeping
 */
public class InBetween10ms implements Task {
    int rep;
    private final int REP_MULTIPLY = 42;
    private final long waitTimeMili;

    public InBetween10ms(int rep, long waitTimeMili) {
        this.rep = rep;
        this.waitTimeMili = waitTimeMili;
    }

    @Override
    public int run() throws InterruptedException {
        long count = 0;
        for (int i = rep; i < rep * REP_MULTIPLY; i++) {
            for (int o = rep; o > 0; o--) {
                for (int p = o; p > 0; p--) {
                    count++;
                }
            }
        }
        Thread.sleep(waitTimeMili);
        return (int) count;

    }
}
