package com.pipi.firstdemo.juc;


import java.util.concurrent.*;

public class ForkJoin {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        Integer invoke = forkJoinPool.invoke(new ErfenserchTask());
        System.out.println("resule" + invoke);
    }


}


class ErfenserchTask extends RecursiveTask<Integer> {
    int num = 5;

    @Override
    protected Integer compute() {
        return (1 + new ErfenserchTask().fork().join());
    }
}