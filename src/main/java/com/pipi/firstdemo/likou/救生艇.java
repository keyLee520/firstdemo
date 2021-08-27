package com.pipi.firstdemo.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 救生艇 {
    public static void main(String[] args) {
        int[] people = {1,2};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    //两者之和=limit 的，两者之或者单个为
    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        for (int i = 0, j = people.length - 1; i < people.length && j >= i; ) {
            if (i == j || people[i] + people[j] <= limit) {
                res++;
                i++;
                j--;
            } else {
                res++;
                j--;
            }
        }

        return res;
    }
}
