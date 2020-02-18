package com.zzj.stringdemo;

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
}
