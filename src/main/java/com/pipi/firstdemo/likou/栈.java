package com.pipi.firstdemo.likou;

public class 栈 {
    static int i = 0;

    public static void main(String[] args) {
        try {
            digui();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }

    private static void digui() {
        i++;
        digui();
    }
}
