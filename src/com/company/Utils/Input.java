package com.company.Utils;

public class Input {
    public int getMode() {
        return mode;
    }

    public Runnable getRunner() {
        return runner;
    }

    public void setRunner(Runnable runner) {
        this.runner = runner;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    private int mode;
    private int userNum;
    private int poolSize;
    private Runnable runner;
}
