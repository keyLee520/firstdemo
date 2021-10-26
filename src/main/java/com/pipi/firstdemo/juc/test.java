package com.pipi.firstdemo.juc;

public class test {
    public static  int num1 = 1;
    public static volatile int num = 1;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num1 = 60;
            num = 60;
        }, "t1").start();


        while (num1 != 60) {

        }

        System.out.println(num);

        System.out.println("60");

    }
}
