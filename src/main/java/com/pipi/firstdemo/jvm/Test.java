package com.pipi.firstdemo.jvm;

public class Test {

    public static int y = 3;
    {
       y=4;
    }
    public void test() {
        Father father = new Father();
        father.dosomething();
        Father child = new Child();
        child.dosomething();
    }
}
