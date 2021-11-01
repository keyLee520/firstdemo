package com.pipi.firstdemo.juc;

public class 线程状态转换终极版 {
    public static void main(String[] args) {
        kuaizi k1 = new kuaizi("1");
        kuaizi k2 = new kuaizi("2");
        kuaizi k3 = new kuaizi("3");
        kuaizi k4 = new kuaizi("4");
        kuaizi k5 = new kuaizi("5");

        zhexuejia z1 = new zhexuejia("苏格拉底", k1, k2);
        zhexuejia z2 = new zhexuejia("柏拉图", k2, k3);
        zhexuejia z3 = new zhexuejia("亚里士多德", k3, k4);
        zhexuejia z4 = new zhexuejia("孙悟空", k4, k5);
        zhexuejia z5 = new zhexuejia("唐僧", k1, k5);

        z1.start();
        z2.start();
        z3.start();
        z4.start();
        z5.start();
    }
}


class zhexuejia extends Thread {
    kuaizi left;
    kuaizi right;

    zhexuejia(String name, kuaizi left, kuaizi right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }
    }

    private void eat() {
        System.out.println(Thread.currentThread().getName() + "吃上了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class kuaizi {
    String name;

    public kuaizi(String name) {
        this.name = name;
    }
}