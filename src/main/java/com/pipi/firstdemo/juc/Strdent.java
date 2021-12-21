package com.pipi.firstdemo.juc;

import java.util.Objects;
import java.util.TreeSet;

public class Strdent {
    String name;

    public Strdent(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
       return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {

    }
}
