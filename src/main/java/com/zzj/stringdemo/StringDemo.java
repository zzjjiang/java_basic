package com.zzj.stringdemo;

import cn.hutool.core.util.StrUtil;
import com.zzj.enumdemo.FeeEnum;
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


    @Test
    public void test004(){
        String template = "{}爱{}，就像老鼠爱大米";
        String str = StrUtil.format(template, "我", "你");
        System.out.println(str);
    }

    @Test
    public void test005(){
        System.out.println(FeeEnum.one.getCode());
        System.out.println(FeeEnum.tow.getCode());
    }

    @Test
    public void subString(){
        String str = "2021-06-10 14:44:46";
        System.out.println(str.substring(0,16));
    }
}
