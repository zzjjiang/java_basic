package com.zzj.clazz.classloader.myloader;

import java.lang.reflect.Method;

public class MyLoaderTest {
    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        //这里是我们目标类的全限定名，根据目标类的package+name来
        Class<?> clazz = loader.findClass("com.zzj.clazz.myloader.Wife");
        try {
            Object o = clazz.getDeclaredConstructor().newInstance();
            Method miss = clazz.getDeclaredMethod("miss");
            miss.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
