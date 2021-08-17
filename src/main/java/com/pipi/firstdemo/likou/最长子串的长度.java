package com.pipi.firstdemo.likou;

import java.util.HashSet;
import java.util.Set;

public class 最长子串的长度 {
    static int num = 0;

    public static void main(String[] args) {
        //ystem.out.println("kikkks".substring(0,1));
        System.out.println(lengthOfLongestSubstring("123"));
    }

    //12345
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i+1;
        }
        return res;
    }


}
