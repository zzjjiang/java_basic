package com.zzj.designPattern.sington;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 懒汉模式
 * @createTime 2020年02月12日 13:32
 */
public class LazyMode {
    private volatile static LazyMode lazyMode = null;
    private LazyMode(){
        System.out.println(Thread.currentThread().getName() + "懒汉模式");
    }

    public static LazyMode getInstance(){
        if(lazyMode == null){
            synchronized (LazyMode.class){
                if(lazyMode == null){
                    lazyMode = new LazyMode();
                }
            }
        }
        return lazyMode;
    }

    public void print(){
        System.out.println("lazy");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> LazyMode.getInstance().print(),"懒汉模式"+i).start();
        }
    }
}
