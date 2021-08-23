package com.pipi.firstdemo.likou;

public class 获取生成数组中的最大值 {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
    }

    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] chars = new int[n + 1];
        chars[0] = 0;
        chars[1] = 1;
        boolean isOu = true;
        int max = 1;
        for (int i = 2; i < chars.length; i++) {
            if (isOu) {
                chars[i] = chars[i / 2];
            } else {
                chars[i] = chars[(i - 1) / 2] + chars[(i - 1) / 2 + 1];
            }
            isOu = !isOu;
            max = Math.max(chars[i], max);
        }
        return max;
    }
}
