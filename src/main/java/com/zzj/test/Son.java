package com.zzj.test;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 结论  接口优先于继承
 * @createTime 2020年03月07日 18:25
 */
public class Son extends Fulei implements Jiekou{

    @Override
    public void testJone() {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Jiekou son = new Son();
        son.testJone();
    }
}
