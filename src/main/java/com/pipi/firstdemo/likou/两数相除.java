package com.pipi.firstdemo.likou;

public class 两数相除 {
    public static void main(String[] args) throws Exception {
        System.out.println(divide(Integer.MIN_VALUE, 1));
    }

    public static int divide(int dividend, int divisor) throws Exception {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long res = div(Math.abs((long) dividend), Math.abs((long) divisor));
        return (int) (dividend > 0 == divisor > 0 ? res : -res);
    }

    private static long div(long a, long b) {
        if (a < b) return 0;
        long res = 0, remainder = 0;
        for (long i = a, count = 1, divier = b; i >= divier; i -= divier, divier += divier, count += count, remainder = i) {
            res += count;
        }
        return res + div(remainder, b);
    }
}
