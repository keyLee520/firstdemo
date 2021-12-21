package com.pipi.firstdemo.juc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//线程安全的类
//String,Integer,
//Vector
//HashTable
//ConcurrentHashMap
//CopyOnWriteArrayList
//StringBuffer
//
public class Safetest {
    public static void main(String[] args) {

        Collection<Object> objects = Collections.synchronizedCollection(new ArrayList<>());
    }
}
