package com.pipi.firstdemo.juc;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.LockSupport;

//-XX:BiasedLockingStartupDelay=0
//禁止偏向锁延迟
public class syncnizedtest {
   /* public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Dog d = new Dog();
        final Thread t1, t2, t3;
        t1 = new Thread(() -> {
            synchronized (d) {
                System.out.println("t1");
                System.out.println(isBiasable(d));
            }
        });
        t1.start();


*//*        t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (d) {
                System.out.println("t2");
                System.out.println(isBiasable(d));
            }
        });
        t2.start();*//*


        t3 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (d) {
                System.out.println("t3");
                System.out.println(isBiasable(d));
            }
        });
        t3.start();

       Thread t4 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (d) {
                System.out.println("t4");
                System.out.println(isBiasable(d));
            }
        });
        t4.start();
    }*/

    /*private static String isBiasable(Object instance) {
        if( ClassLayout.parseInstance(instance).toPrintable().contains("non-biasable")){
            return "无偏向、正常状态";
        }

        if( ClassLayout.parseInstance(instance).toPrintable().contains("biased")){
            return "偏向锁";
        }


        if( ClassLayout.parseInstance(instance).toPrintable().contains("thin lock")){
            return "轻量级锁";
        }
        if( ClassLayout.parseInstance(instance).toPrintable().contains("fat")){
            return "重量级锁";
        }

        return null;
    }*/

}

class Dog {

}