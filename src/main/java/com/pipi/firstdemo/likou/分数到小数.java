package com.pipi.firstdemo.likou;

public class 分数到小数 {
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) {


        fractionToDecimal(1, 2);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }

        int i = 1;
        int lastnumerator = numerator;
        while (true) {
            int value = numerator / denominator;
            int deg = numerator % denominator;
            numerator = deg * 10;
            if (i == 1) {
                res.append(value).append("\\.");
                i++;
                lastnumerator = deg;
                continue;
            }
            if (numerator == lastnumerator) {
                res.append(value);
                return res.toString();
            }
            res.append(value);
        }
    }

    void calc(int numerator, int denominator) {

    }


}
