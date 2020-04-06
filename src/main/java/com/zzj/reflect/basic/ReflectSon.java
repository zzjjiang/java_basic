package com.zzj.reflect.basic;

import java.lang.reflect.Field;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 反射子类
 * @createTime 2020年03月08日 15:15
 */
public class ReflectSon extends ReflectParent{
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Field[] fs1 = ReflectSon.class.getFields();
        for (int i = 0; i < fs1.length; i++) {
            System.out.print(fs1[i].getName()+"-");
        }
        System.out.println("-----------");
        Field[] fs2 = ReflectSon.class.getDeclaredFields();
        for (int i = 0; i < fs2.length; i++) {
            System.out.print(fs2[i].getName()+"-");
        }
    }
}
