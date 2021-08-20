package com.pipi.firstdemo.likou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 最长子串的长度 {
    static int num = 0;

    public static void main(String[] args) {
        //ystem.out.println("kikkks".substring(0,1));
        System.out.println(lengthOfLongestSubstring("1123890hk1s5678914er"));
    }

    //0212345
    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[200];
        Arrays.fill(lastIndex, -1);

        //最新子字符串开始下标
        int startIndex = 0;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            //当前字符最后一次出现的位置
            int currlastIndex = lastIndex[s.charAt(i)];
            //如果此字符在最新
            if (currlastIndex >= startIndex) {
                startIndex = currlastIndex + 1;
            }
            //11231
            int currLength = i - startIndex + 1;
            result = Math.max(currLength, result);
            lastIndex[s.charAt(i)] = i;

        }
        return result;
    }


}
