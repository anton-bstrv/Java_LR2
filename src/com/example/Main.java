package com.example;

public class Main {

    static int sharedValue = 0;

    public static void main(String[] args) {
        CustomSemaphore semaphore = new CustomSemaphore(1);
        System.out.println("Semaphore with 1 permit has been created");

        IncrementThread incrementThread=new IncrementThread(semaphore);
        new Thread(incrementThread,"incrementThread").start();

        DecrementThread decrementThread = new DecrementThread(semaphore);
        new Thread(decrementThread, "decrementThread").start();
    }
}
