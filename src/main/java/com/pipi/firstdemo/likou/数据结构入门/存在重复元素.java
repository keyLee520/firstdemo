package com.pipi.firstdemo.likou.数据结构入门;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
