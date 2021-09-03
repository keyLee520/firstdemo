package com.pipi.firstdemo.likou;

import java.util.*;

public class 三数之和 {
    static int[] newnumms;
    static Map<Integer, Integer> map1;

    public static void main(String[] args1) {
        //System.out.println(threeSum(nums));
        // List<int[]> index = findIndex(0, 1);
        int[] nums = {-1, 0, 1};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(true);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //去重
        for (int num : nums) {
            set.add(num);
        }
        newnumms = new int[set.size()];
        int i = 0;
        map1 = new HashMap<>();
        for (Integer integer : set) {
            newnumms[i] = integer;
            map1.put(-integer, i);
            i++;
        }

        //记录值的下表[-1,0,1,2]
        //map1key是补数、value是下标
        //下边找两数之和为补数的下标
        List<List<Integer>> res = new ArrayList<>();
        map1.forEach((k, v) -> {
            //K 是两数之和 v是下标
            List<List<Integer>> index = findIndex(k, v);
            for (List<Integer> integers : index) {
                if (v < integers.get(0)) {
                    integers.add(0, v);
                }
            }
            res.addAll(index);
        });

        //-1 0 1
        return res;


    }


    /**
     * 寻找两数之和为num,且下标不为index的两组下标
     *
     * @param num
     * @return
     */
    private static List<List<Integer>> findIndex(int num, int index) {
        List list = new ArrayList();
        //mapkey是补数，value是下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newnumms.length; i++) {
            map.put(num - newnumms[i], i);
        }

        for (int i = 0; i < newnumms.length; i++) {
            if (map.containsKey(newnumms[i]) && i != index && i < map.get(newnumms[i])) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                list1.add(map.get(newnumms[i]));
                list.add(list1);
            }
        }
        return list;
    }
}
