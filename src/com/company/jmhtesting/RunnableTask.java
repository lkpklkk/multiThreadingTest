package com.company.jmhtesting;

public class RunnableTask implements Runnable {
    Task task;

    public RunnableTask(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
