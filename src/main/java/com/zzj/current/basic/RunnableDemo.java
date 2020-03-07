package com.zzj.current.basic;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 实现runnable接口
 * @createTime 2020年03月07日 16:15
 */
public class RunnableDemo implements Runnable{


    @Override
    public void run() {
        System.out.println("runnable---"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableDemo one = new RunnableDemo();
        RunnableDemo tow = new RunnableDemo();
        Thread threadOne = new Thread(one, "one");
        Thread threadTow = new Thread(tow, "tow");
        threadOne.start();
        threadTow.start();
    }
}
