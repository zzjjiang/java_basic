package com.zzj.current.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 实现callable，该方式有返回值
 * @createTime 2020年03月07日 16:18
 */
public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int j = 0; j < 100; j++) {
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        Callable callable = new CallableDemo();
        FutureTask<Integer> task = new FutureTask<>(callable);
        System.out.println(Thread.currentThread().getName()+"-----");

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("主线程结束");
        try {
            int i = task.get();
            System.out.println("sum = " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
