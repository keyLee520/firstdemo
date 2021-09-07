package com.pipi.firstdemo.likou;

public class 比较版本号 {
    public static void main(String[] args) {
        System.out.println(compareVersion1("1.00", "1.003"));
        System.out.println((int) '0');
    }

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            int v1 = i + 1 > split1.length ? 0 : Integer.parseInt(split1[i]);
            int v2 = i + 1 > split2.length ? 0 : Integer.parseInt(split2[i]);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }
        return 0;
    }

    public static int compareVersion1(String version1, String version2) {
        for (int i = 0, j = 0; i < version1.length() || j < version2.length(); ) {
            char v1 = i < version1.length() ? version1.charAt(i) : (char) 0;
            char v2 = j < version2.length() ? version2.charAt(j) : (char) 0;
            if (v1 == '0') i++;
            if (v2 == '0') j++;
            if (v1 == '0' || v2 == '0') continue;
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }
}
