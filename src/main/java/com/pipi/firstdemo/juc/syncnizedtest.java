package com.pipi.firstdemo.juc;

import org.openjdk.jol.info.ClassLayout;

import javax.management.monitor.Monitor;

public class syncnizedtest {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(ClassLayout.parseInstance(d).toPrintable());
    }


}

class Dog {

}