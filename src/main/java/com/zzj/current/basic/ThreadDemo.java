package com.zzj.current.basic;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 继承thread
 * @createTime 2020年03月07日 16:11
 */
public class ThreadDemo extends Thread{

    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("-------"+Thread.currentThread().getName()+"-------");
    }

    public static void main(String[] args) {
        ThreadDemo one = new ThreadDemo("one");
        ThreadDemo tow = new ThreadDemo("tow");
        one.start();
        tow.start();
    }
}
