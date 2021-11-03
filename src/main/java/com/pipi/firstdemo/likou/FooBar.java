package com.pipi.firstdemo.likou;


import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }
    Semaphore semaphore = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}