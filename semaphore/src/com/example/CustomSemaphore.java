package com.example;

public class CustomSemaphore {
    private int permits;

    public CustomSemaphore(int permits) {
        this.permits=permits;
    }

    public synchronized void acquire() throws InterruptedException {
        if (permits <= 0) {
            this.wait();
        }
        permits--;
    }

    public synchronized void release() {
        permits++;

        if(permits > 0)
            this.notify();
    }
}
