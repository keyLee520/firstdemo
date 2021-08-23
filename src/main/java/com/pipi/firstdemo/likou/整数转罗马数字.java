package com.pipi.firstdemo.likou;

import java.util.HashMap;
import java.util.Map;

public class 整数转罗马数字 {
    public static void main(String[] args) {
        //System.out.println(3999 / 1000 * 1000);
        System.out.println(intToRoman(3999));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "LC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");

        //千位
        int thousands = num / 1000 * 1000;
        //百位
        int hundreds = num / 100 * 100 - thousands;

        //十位
        int tens = num / 10 * 10 -thousands-hundreds ;

        //个位
        int single = num % 10;

        StringBuilder builder = new StringBuilder();
        if (thousands != 0) builder.append(map.get(thousands));
        if (hundreds != 0) builder.append(map.get(hundreds));
        if (tens != 0) builder.append(map.get(tens));
        if (single != 0) builder.append(map.get(single));
        return builder.toString();
    }
}
