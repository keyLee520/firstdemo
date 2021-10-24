package com.pipi.firstdemo.juc;

public class waitandsleep {

    static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");
        t2.start();

        Thread.sleep(1000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        synchronized (o) {
            o.notifyAll();
        }
    }
}
