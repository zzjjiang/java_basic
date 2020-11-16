package com.zzj.generic.wildcard;

import com.zzj.generic.clazz.GenericClassDemo;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 泛型通配
 * @createTime 2020年09月03日 22:43
 *
 * 　　1）使用？可以接收任意泛型对象。
 *
 * 　　2）泛型的上限：？extends 类型。
 *
 * 　　3）泛型的下限：？super 类型。相对了解一些就可。
 */
public class WildCardDemo {

    public static void main(String[] args) {
        GenericClassDemo<Number> demo1 = new GenericClassDemo<>();

        GenericClassDemo<Integer> demo2 = new GenericClassDemo<>();
        testNum(demo1);
//        报错说明泛型是单独的，不同版本的泛型类实例是不兼容的。不存在父子关系
//        testNum(demo2);


    }
/*
解决方式：？想当于是所有类型的父类
public static void testNum(GenericClassDemo<?> demo){
        System.out.println(demo.getVar());
    }

 */
    public static void testNum(GenericClassDemo<Number> demo){
        System.out.println(demo.getVar());
    }

    public static void testInt(GenericClassDemo<Integer> demo){
        System.out.println(demo.getVar());
    }
}
