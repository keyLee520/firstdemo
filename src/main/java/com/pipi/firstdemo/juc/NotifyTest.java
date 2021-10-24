package com.pipi.firstdemo.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotifyTest {
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "其他代码");
            }

        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "其他代码");
            }

        }, "t2");
        t2.start();

        Thread.sleep(1000);
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "我来解救你们");
            lock.notify();
        }

        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
