package com.pipi.firstdemo.likou;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet();
        set.add("狗屎55");
        set.add("狗屎");
        set.add("2");
        set.forEach(se -> System.out.println(se + se.hashCode()));
    }
}
