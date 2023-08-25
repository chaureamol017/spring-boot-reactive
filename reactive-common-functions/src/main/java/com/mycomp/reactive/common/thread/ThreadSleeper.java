package com.mycomp.reactive.common.thread;

public class ThreadSleeper {

    public static void sleepExecution(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
