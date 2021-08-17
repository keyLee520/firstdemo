package com.pipi.firstdemo.likou;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 两数之和 {
    public static void main(String[] args) {
        //1234
        System.out.println(reverse(-2147483648));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 1; i1 < nums.length; i1++) {
                if (i == i1) {
                    continue;
                }
                if (nums[i] + nums[i1] == target) {
                    return new int[]{i, i1};
                }
            }
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int jinwei = 0;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (true) {
            if (jinwei == 0 && p1 == null && p2 == null) {
                break;
            }
            int value = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + jinwei;
            jinwei = value / 10;
            p.next = new ListNode(value % 10);
            ;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            p = p.next;
        }
        return result.next;
    }


    private ListNode calccurrNode(int i1, int i2, int over) {
        int value = (i1 + i2 + over);
        int yushu = value % 10;
        int zhengshu = value / 10;
        //overValue = zhengshu;
        ListNode result = new ListNode();
        result.val = yushu;
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //012345
    //123321
    //s=aabaa
    public static int longestPalindromeSubseq(String s) {
        //dp[]表示下标范围内最长回文子序列的长度
        int dp[][] = new int[s.length()][s.length()];
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    //012343215
    //12321
    private boolean isSe(String s) {
        int index;
        int length = s.length();
        if (length % 2 == 0) {
            index = length / 2 - 1;
        } else {
            index = length / 2;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < index; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //1234
    //2134
    //3214
    //4231
    //1432
    //4132
    //2431
    //3421
    public static int countArrangement(int n) {


        int count = 1;
        for (int i = 1; i < n; i++) {

        }
        return count;
    }

    public static int reverse(int x) {

        String s = String.valueOf(x).replace("-", "");
        char[] chars = s.toCharArray();
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars1[chars.length - 1 - i] = chars[i];
        }


        long long1 = new Long(String.valueOf(chars1));

        if ((x < 0 && long1 > Math.pow(2, 31)) || (x > 0 && long1 > Math.pow(2, 31) - 1)) {
            return 0;
        }
        if (x < 0) {
            return -(int) long1;
        } else {
            return (int) long1;
        }
    }
}