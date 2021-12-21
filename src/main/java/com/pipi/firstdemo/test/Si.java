package com.pipi.firstdemo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Si {
    private static Si instance = new Si();

    private Si() {

    }

    public static Si getInstance() {
        return instance;
    }
}


class Si1 {
    private static volatile Si1 instance = null;

    private Si1() {

    }

    //new 对象
    //分配空间
    //初始化属性
    //指针指向地址

    public static Si1 getInstance() {
        if (instance == null) {
            synchronized (Si1.class) {
                if (instance == null) {
                    instance = new Si1();
                }
            }
        }
        return instance;
    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(123);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (Si.class){
                try {
                    Si.class.wait(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
        },"t1");

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }




}