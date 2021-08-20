package com.pipi.firstdemo.likou;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class Powxn {
    double result = 1.0;

    //-2147483648
    //2的7次方 = 2 2 2
    public static void main(String[] args) {
        System.out.println(planb(3,
                7));

    }


    /**
     * 2 7 = 22 * 21 * 2
     * 3 *
     *
     * @param x
     * @param n
     * @return
     */
    public static double planb(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;

    }

    /**
     * 计算x的平方
     *
     * @param x
     */
    private static double square(double x) {
        return x * x;
    }

    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }
        int abs = Math.abs(n);
        double result = 1.0;
        for (int i = 0; i < abs; i++) {
            result *= x;

        }
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }
}
