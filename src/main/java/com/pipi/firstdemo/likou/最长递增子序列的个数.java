package com.pipi.firstdemo.likou;

import java.util.Arrays;

public class 最长递增子序列的个数 {
    public static void main(String[] args) {
        System.out.println(1235);
    }

    //23232323232
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        //动态规划
        //maxs[i][0]表示以num[i]结尾
        int[] maxs = new int[nums.length];
        int max = nums[0];
        int length = 1;
        maxs[0] = 1;
        for (int i = 1; i < nums.length; i++) {

        }
        return 8;
    }
}
