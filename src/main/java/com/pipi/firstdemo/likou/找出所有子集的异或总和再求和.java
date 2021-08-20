package com.pipi.firstdemo.likou;

import java.util.ArrayList;
import java.util.List;

public class 找出所有子集的异或总和再求和 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 6};
        System.out.println(subsetXORSum(nums));
    }

    //1234
    public static int subsetXORSum(int[] nums) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        for (int num : nums) {
            tmpList = new ArrayList<>();
            for (Integer integer : list) {
                int tmp = integer ^ num;
                sum += tmp;
                //System.out.println(integer + "和" + num + "的异或结果为：" + (integer ^ num));
                //System.out.println("sum:" + sum);
                tmpList.add(tmp);
            }
            list.addAll(tmpList);
            sum += num;
            //System.out.println(num + "的自己结果为:" + num);
            list.add(num);
        }
        return sum;
    }

}
