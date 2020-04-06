package com.zzj.designpattern.creationalpattern.builder.base;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 指挥类
 * @createTime 2020年04月06日 12:57
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void create() {
        builder.buildRope();
        builder.buildHat();
        builder.buildCupBody();
        builder.getResult().show();
    }

    public static void main(String[] args) {
        Director d = new Director(new ConcrateBuilder());
        d.create();
    }

}
