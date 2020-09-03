package com.zzj.generic.methodz;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 一般泛型方法，修饰符与返回值之间必须要有<T>--泛型声明
 * @createTime 2020年09月03日 23:27
 */
public class SimpleMethodDemo<K> {

    public <T> void test(T t){
        System.out.println(t);
    }

    public <T> T test1(K k,T t){
        System.out.println(t);
        return t;
    }

    // 定义多个泛型类型
    public <T,E> T test2(E e,T t){
        System.out.println(t);
        return t;
    }

    // 静态方法中出现泛型，必须将方法定义为泛型方法，加上泛型声明
    public static <K> K test2(K t){
        System.out.println(t);
        return t;
    }
    /*
    此种写法会报错
    public static K test2(K t){
        System.out.println(t);
        return t;
    }
     */
}
