package com.pipi.firstdemo.likou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class 最小K个数 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[] ints = new int[190000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints.length - i;
        }


        /*Arrays.sort(ints);*/
        IntStream sorted = Arrays.stream(ints).sorted();
        OptionalInt first = sorted.findFirst();
        int asInt = first.getAsInt();
        System.out.println(asInt);
        long l1 = System.currentTimeMillis();
        System.out.println("时间:" + (l1 - l));
    }

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] array;
        if (arr.length < k) {
            array = new int[arr.length];
            System.arraycopy(arr, 0, array, 0, arr.length);
        } else {
            array = new int[k];
            if (k >= 0) System.arraycopy(arr, 0, array, 0, k);
        }

        return array;
    }


    public int[] smallestK1(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] ints = new int[k];
        if (k == 0) return new int[0];
        if (k >= arr.length) return arr;

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.element() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; ++i) {
            ints[i] = queue.poll();
        }
        return ints;
    }
}
