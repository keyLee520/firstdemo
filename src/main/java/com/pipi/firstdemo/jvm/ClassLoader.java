package com.pipi.firstdemo.jvm;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
  /*      System.out.println("启动类加载器");
        for (URL url : Launcher.getBootstrapClassPath().getURLs()) {
            //System.out.println(url.toExternalForm());
            System.out.println(url.toString());
        }

        System.out.println(String.class.getClassLoader());
        System.out.println("扩展类加载器");
        String property = System.getProperty("java.ext.dirs");
        for (int i = 0; i < property.split(";").length; i++) {
            System.out.println(property.split(";")[i]);
        }*/

        Class<?> aClass = new com.sun.org.apache.bcel.internal.util.ClassLoader().loadClass("com.pipi.firstdemo.jvm.ClassLoader.My");
        System.out.println(aClass);
        com.pipi.firstdemo.jvm.ClassLoader.My my = new My();
        System.out.println(my.getClass().getClassLoader());
    }



    static class My {
        String f = "sd";
    }
}


