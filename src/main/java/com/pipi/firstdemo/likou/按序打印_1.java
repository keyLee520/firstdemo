package com.pipi.firstdemo.likou;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class 按序打印_1 {
    Fooo foo = new Fooo();

    Thread t1 = new Thread();

}


class Fooo {
    Semaphore first = new Semaphore(0);
    Semaphore second = new Semaphore(0);

    public Fooo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
LockSupport.park();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}