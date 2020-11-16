package com.zzj.stringdemo;

import org.junit.Test;

/**
 * @author Jone
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年08月19日 22:48
 */
public class StringDemo {

    @Test
    public void test001(){
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);

    }

    @Test
    public void test002(){
        String s1 = new String("abc").intern();
        String s2 = new String("abc").intern();
        System.out.println(s1 == s2);

    }

    @Test
    public void test003(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

    }

}
