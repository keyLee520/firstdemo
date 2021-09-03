package com.pipi.firstdemo.likou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 按权重随机选择 {
    static int[] w = {1, 2, 3, 4};
    static int[][] ww = new int[w.length][2];

    public 按权重随机选择(int[] w) {
        按权重随机选择.w = w;
        按权重随机选择.ww = new int[w.length][2];
    }


    public static void main(String[] args) {
        System.out.println(pickIndex());
    }

    public static int pickIndex() {
        int sum = Arrays.stream(w).sum();
        int start = 1;
        int end = 0;
        for (int i = 0; i < w.length; i++) {
            end += w[i];
            ww[i][0] = start;
            ww[i][1] = end;
            start = start + w[i];
        }

        int random = (int) (Math.random() * sum);
        int starts = 0, ends = w.length - 1;

        while (true) {
            int index = (starts + ends) / 2;
            int min = ww[index][0];
            int max = ww[index][1];
            if (random > max) {
                starts = index + 1;
            } else if (random < min) {
                ends = index - 1;
            } else {
                return index;
            }
        }
    }

    //012 es
    //01
    private int findi(int target, int start, int end) {
        //找中间
        while (true) {
            int index = (start + end) / 2;
            int min = ww[index][0];
            int max = ww[index][1];
            if (target > max) {
                start = index + 1;
            } else if (target < min) {
                end = index - 1;
            } else {
                return index;
            }
        }
    }


}
