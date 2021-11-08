package com.pipi.firstdemo.jvm;

public class JitTest {
    //-Xint 仅使用解释器
    //-Xcomp
    //-Xmixed
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            int c = i % 5;
            int u = c * 452;
        }

        long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
    }
}
