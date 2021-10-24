package com.pipi.firstdemo.juc;

import java.util.concurrent.locks.LockSupport;

public class ParkAndUnpark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"parkle");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"unparkle");
        });
        t1.start();

        Thread.sleep(4000);
        LockSupport.unpark(t1);

    }


}
