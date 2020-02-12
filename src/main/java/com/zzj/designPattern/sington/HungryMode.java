package com.zzj.designPattern.sington;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 饿汉模式
 * @createTime 2020年02月12日 13:25
 */
public class HungryMode {


    private static HungryMode instance = new HungryMode();

    /**
     * 私有构造
     */
    private HungryMode(){
        System.out.println("饿汉模式");
    }

    public static HungryMode getInstance(){
        return instance;
    }

    public void print(){
        System.out.println("lazy");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {HungryMode.getInstance().print();},"饿汉"+i).start();
        }

    }
}
