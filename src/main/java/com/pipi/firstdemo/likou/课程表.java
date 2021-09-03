package com.pipi.firstdemo.likou;

import java.util.*;

public class 课程表 {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //map保存当前课程的先修课程
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.get(prerequisite[0]) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisite[1]);
                map.put(prerequisite[0], set);
            } else {
                map.get(prerequisite[0]).add(prerequisite[1]);
            }
        }

        //保存入度
        int[] rudu = new int[numCourses];
        for (int i = 0; i < rudu.length; i++) {
            rudu[i] = map.get(i) == null ? 0 : map.get(i).size();
        }

        //已完成的数量
        int res = 0;



        Map<Integer, Integer> map1 = new HashMap<>();
        for (int[] prerequisite1 : prerequisites) {
            map1.put(prerequisite1[0], prerequisite1[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            set.add(i);
        }

        Set<Integer> done = new HashSet<>();

        for (Integer integer : set) {
            //如果已修，不必理会
            if (done.contains(integer)) continue;
            //修改integer之前必须修kecheng查询
            Integer requre = map1.get(integer);

            //不用修
            if (requre == null) {
                done.add(integer);
                continue;
            } else {
                //先修课程requre
                done.add(requre);
                //以及那修课程可修
                map.get(requre).forEach(e -> done.add(e));
            }
        }

        return true;
    }


}
