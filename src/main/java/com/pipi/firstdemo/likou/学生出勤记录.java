package com.pipi.firstdemo.likou;

public class 学生出勤记录 {
    public static void main(String[] args) {
        System.out.println(checkRecord("LKFSJSKD"));
    }

    public static boolean checkRecord(String s) {
       /* //A缺勤，L迟到
        int AbsentDays = 0;
        if (s.contains("LLL")) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c == 'A' && ++AbsentDays > 1) {
                return false;
            }
        }
        return true;*/

        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}

