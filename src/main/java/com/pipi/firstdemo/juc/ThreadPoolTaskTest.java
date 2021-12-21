package com.pipi.firstdemo.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadPoolTaskTest {
    public static void main(String[] args) {
        //
        List<String> list = Arrays.asList("1","2","3");
        int i = 4;
        list.forEach(li->{
            System.out.println(li);
        });

    }
}
