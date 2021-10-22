package com.pipi.firstdemo.likou;

import java.util.Arrays;

public class 超级洗衣机 {
    // [1,0,5]
    //  2 2 2
    public int findMinMoves(int[] machines) {
        //222
        //123
        //114
        //105
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        int av = sum / machines.length;
        int[] ave = new int[machines.length];
        Arrays.fill(ave, av);

        int[] calc = new int[machines.length];

        for (int i = 0; i < machines.length; i++) {

        }
        return 1;
    }
}
