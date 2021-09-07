package com.pipi.firstdemo.likou;


import java.util.Arrays;

public class erfen {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int i = Arrays.binarySearch(nums, 3);
        System.out.println(i);

    }

    //012345
    //01234
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (true) {
            int index = (start + end) / 2;
            int mid = nums[index];
            if (target < mid) {
                end = end - 1;
            } else if (target > mid) {
                start = start + 1;
            } else {
                return index;
            }
        }
    }
    public int search1(int[] nums, int target) {
        Arrays.toString(nums).indexOf(String.valueOf(target));
        return 1;
    }
}
