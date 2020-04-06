package com.zzj.designpattern.creationalpattern.builder.base;

/**
 * @author Jone
 * @version 1.0.0
 * @Description Product
 * @createTime 2020年04月06日 12:44
 */
public class Cup {

    /**
     * 绳子
     */
    private String rope;

    /**
     * 帽子
     */
    private String hat;
    /**
     * 杯体
     */
    private String cupBody;

    public String getRope() {
        return rope;
    }

    public void setRope(String rope) {
        this.rope = rope;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getCupBody() {
        return cupBody;
    }

    public void setCupBody(String cupBody) {
        this.cupBody = cupBody;
    }

    public void show(){
        System.out.println("杯子修改完毕");
    }
}
