package com.pipi.firstdemo.jvm;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//-XX:+PrintGCDetails 打印GC的详细信息
//-XX:InitialHeapSize or -Xms heap初始大小
//--X:MaxHeapSize or -Xmx heap最大大小

//-XX:InitialHeapSize=10m -XX:MaxHeapSize=10m
public class HeapDemo {
    public static void main(String[] args) throws InterruptedException {
        /*Runtime runtime = Runtime.getRuntime();
        System.out.println("max："+runtime.maxMemory()/1024/1024+"M");
        System.out.println("total："+runtime.totalMemory()/1024/1024+"M");
       Thread.sleep(100000220);*/


        List<String>  lsit = new ArrayList<>();
        while (true){
            lsit.add(new String("7856"));
        }

    }


}
