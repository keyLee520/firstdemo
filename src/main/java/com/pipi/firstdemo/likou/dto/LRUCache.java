package com.pipi.firstdemo.likou.dto;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map;
    Map<Integer, Integer> map1;
    int capacity;
    int time;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        map1 = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return 0;
        }
        map1.put(key, ++time);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.keySet().size() == capacity){
        }

    }

}
