package com.pipi.firstdemo.juc;

import java.util.concurrent.locks.LockSupport;

public class parkandu {

    public static void main(String[] args) throws InterruptedException {
        Thread   t1=new Thread(()->{
            LockSupport.park();
            System.out.println(123);
        });t1.start();


        Thread.sleep(1000);
        System.out.println("t1 unpark");
        LockSupport.unpark(t1);

        new Object().wait();

    }

}
