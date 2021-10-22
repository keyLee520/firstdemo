package com.pipi.firstdemo.likou;

public class 分割平衡字符串 {
    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }

    //RL RRRLLRLL
    public static int balancedStringSplit(String s) {
        int rCount = 0, lCount = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') rCount++;
            else if (c == 'L') lCount++;
            if (rCount == lCount) {
                res++;
                rCount = 0;
                lCount = 0;
            }
        }
        return res;
    }
}
