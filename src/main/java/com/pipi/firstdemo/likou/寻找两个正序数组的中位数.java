package com.pipi.firstdemo.likou;

import java.util.HashMap;
import java.util.Map;

public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenth = nums1.length + nums2.length;
        if (lenth % 2 == 0) {
            //234
            //125
            //123456
            //lenth/2-1 和lenth/2 de shu 3 4
            //二分法查找
            //
        }
        return 0;
    }

}

