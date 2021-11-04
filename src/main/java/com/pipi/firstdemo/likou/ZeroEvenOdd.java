package com.pipi.firstdemo.likou;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    CountDownLatch latch = new CountDownLatch(1);

    AtomicInteger hcount = new AtomicInteger(0);
    AtomicInteger ocount = new AtomicInteger(0);



    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        z.acquire();
        printNumber.accept(0);
        e.release();
        o.acquire();
        latch.countDown();

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        e.acquire();
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                printNumber.accept(i);
            }
        }
        o.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        o.acquire();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                printNumber.accept(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(0 % 2);
    }
}
