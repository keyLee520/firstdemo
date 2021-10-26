package com.pipi.firstdemo.likou;

import java.util.concurrent.locks.LockSupport;

public class 按序打印 {
    Foo foo = new Foo();

    Thread t1 = new Thread();


}


class Foo {

 volatile    boolean  seconEnable = false;
    boolean thirdEnable = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        seconEnable = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!seconEnable) {
                wait();
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdEnable = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!thirdEnable) {
                wait();
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}