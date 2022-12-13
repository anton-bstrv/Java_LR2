package com.example;

public class DecrementThread implements Runnable {
    CustomSemaphore customSemaphore;

    public DecrementThread(CustomSemaphore customSemaphore) {
        this.customSemaphore = customSemaphore;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " is waiting for permit");

        try {
            customSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() +
                    " has got permit");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() +
                        " >" + Main.sharedValue--);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() +
                " has released permit");
        customSemaphore.release();


    }
}
