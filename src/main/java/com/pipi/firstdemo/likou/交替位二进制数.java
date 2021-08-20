package com.pipi.firstdemo.likou;

//
public class 交替位二进制数 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(10));
    }

    public static boolean hasAlternatingBits(int n) {
        return "1010101010101010101010101010101".contains(Integer.toBinaryString(n));
    }
}