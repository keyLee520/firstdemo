package com.pipi.firstdemo.likou;

public class 二分查找 {
    static int[] nums = {1, 2, 4, 8, 9, 10, 45, 76};

    public static void main(String[] args) {
        int start = 0;
        int end = nums.length;
        System.out.println(find(76, 0, nums.length - 1));

    }


    private static int find(int num, int start, int end) {
        //中间
        int index = (int) (start + end) / 2;
        if (num == nums[index]) return index;
        else if (num > nums[index]) return find(num, index + 1, end);
        else return find(num, start, index - 1);
    }
}
