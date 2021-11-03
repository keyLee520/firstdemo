package com.pipi.firstdemo.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLanchTest {
    public static void main(String[] args) {
       synchronized (CountDownLanchTest.class){
           System.out.println(123);
 
       }
    }


}
