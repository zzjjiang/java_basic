package com.zzj.designpattern.creationalpattern.builder.base;

/**
 * @author Jone
 * @version 1.0.0
 * @Description ConcrateBuilder
 * @createTime 2020年04月06日 12:52
 */
public class ConcrateBuilder extends Builder{
    @Override
    public void buildRope() {
        cup.setRope("生产绳子...");
        System.out.println("生产绳子...");
    }

    @Override
    public void buildHat() {
        cup.setHat("生产帽子...");
        System.out.println("生产帽子...");
    }

    @Override
    public void buildCupBody() {
        cup.setCupBody("生产杯体...");
        System.out.println("生产杯体...");
    }
}
