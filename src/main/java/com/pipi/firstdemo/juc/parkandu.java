package com.pipi.firstdemo.juc;

import java.util.concurrent.locks.LockSupport;

public class parkandu {

    public static void main(String[] args) throws InterruptedException {
        Thread   t1=new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println(123);
            LockSupport.park();
            System.out.println(456);
        });t1.start();


        Thread.sleep(1000);
        System.out.println("t1 unpark");
        LockSupport.unpark(t1);

        Thread.sleep(3000);

        LockSupport.unpark(t1);

    }

}
