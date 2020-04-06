package com.zzj.designpattern.creationalpattern.builder.base;

/**
 * @author Jone
 * @version 1.0.0
 * @Description build类
 * @createTime 2020年04月06日 12:50
 */
public abstract class Builder {
    protected Cup cup = new Cup();

    public abstract void buildRope();

    public abstract void buildHat();

    public abstract void buildCupBody();

    public  Cup getResult() {
        return cup;
    }
}
