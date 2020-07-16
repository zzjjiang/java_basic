package com.zzj.stringdemo;

import org.junit.Test;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 字符串大小写处理
 * @createTime 2020年02月15日 19:29
 */
public class StringUpLowDemo {

    public static void main(String[] args) {
        String str = "jone";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - 32);
        }
        System.out.println(new String(chars));
    }

    @Test
    public void test(){
//        String s1 = "hello world";
        String s1 = "a ";
        System.out.println(s1.length());
        System.out.println(s1.trim().length());
        //splits长度为1
        String[] splits = s1.split(" ");
        int length = splits.length;
        if(length == 1){
            System.out.println("0");
        }else{
            System.out.println(splits[length - 1].length());
        }

    }

    /**
     * 说明一个空格占一个位  长度为1
     */

    @Test
    public void testSpace(){
        String s1 = " ";
        //1
        System.out.println(s1.length());
        //0
        System.out.println(s1.trim().length());

    }
}
