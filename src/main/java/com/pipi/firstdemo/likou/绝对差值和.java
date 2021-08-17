package com.pipi.firstdemo.likou;

public class 绝对差值和 {

    public static void main(String[] args) {

    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0;
        int[] tmp = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int tm = nums1[i] - nums2[i];
            tmp[i] = tm < 0 ? -tm : tm;
        }
        return 0;
    }
}
