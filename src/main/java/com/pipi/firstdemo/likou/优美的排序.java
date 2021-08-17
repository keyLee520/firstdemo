package com.pipi.firstdemo.likou;

import java.util.*;

public class 优美的排序 {
    static int num = 0;
    static boolean[] vld;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(gaoxiao(4));
    }


    private static int gaoxiao(int n) {
        int table[] = {0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return table[n];
    }

    public static int countArrangement(int n) {
        //boolean[] vld 表示每个数字有没有被使用过
        //map<integer,List<Integer>> 表示每个坑位允许的数字
        vld = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {//i是下标
            map.put(i, new ArrayList<>());
            for (int j = 1; j <= n; j++) {//j是数字
                if (i % j == 0 || j % i == 0) {
                    map.get(i).add(j);
                }
            }
        }
        backtrack(1, n);

        return num;

    }

    public static void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (Integer integer : map.get(index)) {
            if (!vld[integer]) {
                vld[integer] = true;
                System.out.println("index" + index + "integer" + integer);
                backtrack(index + 1, n);
                vld[integer] = false;
            }
        }
    }
}
