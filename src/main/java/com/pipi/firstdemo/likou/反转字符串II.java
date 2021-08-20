package com.pipi.firstdemo.likou;

public class 反转字符串II {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefgr", 3));
    }


    //12345 2
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = k - 1;
        while (i < s.length() - 1) {
            if (j > s.length() - 1) {
                j = s.length() - 1;
            }
            revert(chars, i, j);
            i += 2 * k;
            j += 2 * k;
        }
        return new String(chars);
    }

    private static void revert(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
