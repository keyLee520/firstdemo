package com.pipi.firstdemo.juc;

import java.util.Objects;

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
}
