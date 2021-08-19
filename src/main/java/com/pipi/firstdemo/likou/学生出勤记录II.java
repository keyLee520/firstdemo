package com.pipi.firstdemo.likou;

/**
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 */
public class 学生出勤记录II {
    static char[] record = {'A', 'L', 'P'};
    static int num = 0;
    //连续迟到次数
    static int count = 0;
    //缺勤总次数
    static int absentCount = 0;

    //迟到次数记录
    static int[] counts;
    //缺勤总次数
    static int[] absentCounts;

    public static void main(String[] args) {
        // System.out.println(1 % Integer.MAX_VALUE);
        // System.out.println(checkRecord(15));

        System.out.println(planb(10101));
    }


    //3
    public static long planb(int n) {
        //长度为i情况可奖励由一下情况组成
        /**
         * 1、缺勤数量0   末尾连续迟到0
         * 2、缺勤数量为0 末尾连续迟到1
         * 3、缺勤数量为0 末尾连续迟到2
         * 4、缺勤数量为1 末尾连续迟到0
         * 5、缺勤数量为1 末尾连续迟到1
         * 6、缺勤数量为1 末尾连续迟到2
         */

        //则有长度为i+1情况可奖励由一下情况组成
        /**
         * 1、缺勤数量0   末尾连续迟到0  = i
         * 2、缺勤数量为0 末尾连续迟到1 =
         * 3、缺勤数量为0 末尾连续迟到2
         * 4、缺勤数量为1 末尾连续迟到0
         * 5、缺勤数量为1 末尾连续迟到1
         * 6、缺勤数量为1 末尾连续迟到2
         */

        //1缺勤0连续 = 0缺勤 0 连续 +缺勤

        long[][][] dp = new long[n + 1][2][3];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][0][2] = 0;
        dp[1][1][0] = 1;
        dp[1][1][1] = 0;
        dp[1][1][2] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % 1000000007;
            dp[i][0][1] = (dp[i - 1][0][0]) % 1000000007;
            dp[i][0][2] = (dp[i - 1][0][1]) % 1000000007;
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % 1000000007;
            dp[i][1][1] = (dp[i - 1][1][0]) % 1000000007;
            dp[i][1][2] = (dp[i - 1][1][1]) % 1000000007;
        }

        return (int) ((dp[n][0][0] +
                +dp[n][0][1]
                + dp[n][0][2]
                + dp[n][1][0]
                + dp[n][1][1]
                + dp[n][1][2]) % 1000000007);
    }

    /**
     * 能拿到奖励
     *
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    //'A'：Absent，缺勤
    //'L'：Late，迟到
    //'P'：Present，到场
    public static int checkRecord(int n) {
        //初始化
        counts = new int[n + 1];
        absentCounts = new int[n + 1];

        backtrack(1, n);
        return num;
    }


    /**
     * n是长度
     *
     * @param index 下标
     * @param n     长度
     */
    private static void backtrack(int index, int n) {
        if (index > n) {
            num++;
            return;
        }

        //尝试向第index的位置放入考勤记录
        for (char i : record) {
            if (i == 'A') {
                if (absentCount == 1) {
                    continue;
                } else {
                    absentCount++;
                }
            } else if (i == 'L') {
                if (count == 2) {
                    continue;
                } else {
                    count++;
                }
            } else {
                count = 0;
            }
            //当前位置状态记录
            absentCounts[index] = absentCount;
            counts[index] = count;
            // System.out.println("index:" + index + ":" + String.valueOf(i));
            backtrack(index + 1, n);
            //回溯状态还原还原
            absentCount = absentCounts[index - 1];
            count = counts[index - 1];
        }

    }


}
