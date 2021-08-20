package com.pipi.firstdemo.likou;

import java.util.*;

public class 反转元音字母 {
    static Map<Character, Byte> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(reverseVowels("aesirou"));
    }


    public static String reverseVowels(String s) {
        map.put('a', null);
        map.put('e', null);
        map.put('i', null);
        map.put('o', null);
        map.put('u', null);
        map.put('A', null);
        map.put('E', null);
        map.put('I', null);
        map.put('O', null);
        map.put('U', null);

        char[] chars = s.toCharArray();
        boolean isVowel = false;

        for (int i = 0, j = chars.length - 1; i < chars.length && j > i; ) {
            if (!isVowel) {
                if (!isVowel(chars[i])) {
                    i++;
                    continue;
                }
            }

            isVowel = true;
            if (!isVowel(chars[j])) {
                j--;
                continue;
            }
            isVowel = false;
            chars[i] = chars[j];
            chars[j] = s.charAt(i);
            i++;
            j--;
        }
        return new String(chars);

    }

    private static boolean isVowel(char c) {
        return map.containsKey(c);
    }


}
