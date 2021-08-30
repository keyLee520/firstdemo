package com.pipi.firstdemo.likou;

import java.util.TreeSet;

public class 存在重复元素III {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3, t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

    }

    //      [0,1,2,3,4]
    //nums = [2,1,3,4,1], k = 3, t = 0
    //abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) (nums[i] - (long) t));
            if (ceiling != null && ceiling <= (long) (nums[i] + (long) t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
