package com.pipi.firstdemo.likou;

import java.util.Arrays;
import java.util.stream.IntStream;

public class H指数 {
    public static void main(String[] args) {
        int[] s = {3,0,6,1,5};
        System.out.println(hIndex1(s));
    }

    //0123
    //二分查找法
    public static int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        long maybe = 0;
        while (start <= end) {
            int index = (start + end) / 2;
            //查询引用次数>= index 的数量
            IntStream stream = Arrays.stream(citations);
            long count = stream.filter(e -> e >= index + 1).count();
            if (count >= index + 1) {
                maybe = index + 1;
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return (int) maybe;
    }

    //01356
    public static int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int start = 0;
        int end = citations.length - 1;
        int maybe = 0;
        while (start <= end) {
            int index = (start + end) / 2;
            //查询引用次数>= index 的数量
            if (citations[citations.length-1 - index] >= index + 1) {
                maybe = index + 1;
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return maybe;
    }
}
