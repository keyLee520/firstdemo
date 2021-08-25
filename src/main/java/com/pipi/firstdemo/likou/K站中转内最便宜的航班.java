package com.pipi.firstdemo.likou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K站中转内最便宜的航班 {
    public static void main(String[] args) {

    }

    /**
     * n = 3个城市, edges = [[0,1,100],[1,2,100],[0,2,500]] 航班
     * src = 0 出发地, dst = 2 目的地, k = 1 最多k次换乘
     * 输出: 200
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        for (int i = 0; i < n - 1; i++) {

        }
        return 100;
    }

    /**
     * 连接航班
     */
    private int[] concat(int[] flight1, int[] flight2) {
        if (flight1[1] == flight2[0]) {
            int[] arr = {flight1[0], flight2[1], flight1[2] + flight2[2]};
            return arr;
        } else if (flight2[1] == flight1[0]) {
            int[] arr = {flight2[0], flight1[1], flight2[2] + flight1[2]};
            return arr;
        } else {
            return null;
        }
    }
}

