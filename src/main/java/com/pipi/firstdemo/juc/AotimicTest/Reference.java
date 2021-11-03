package com.pipi.firstdemo.juc.AotimicTest;



import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Reference {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        Unsafe unsafe = Unsafe.getUnsafe();
    }
}
