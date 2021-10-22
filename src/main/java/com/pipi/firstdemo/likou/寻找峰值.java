package com.pipi.firstdemo.likou;

public class 寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        //只有一个元素
        if(nums.length==1){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            //第一个元素
            if(i==0){
                if( nums[i]>nums[i+1]){
                    return i;
                }else {
                    continue;
                }

            }

            //最后一个元素
            if(i==nums.length-1 ){
                if(nums[i]>nums[i-1]){
                    return i;
                }else {
                    continue;
                }
            }

            //不是第一个元素也不是最后一个元素
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }

        }

        return 0;
    }
}




