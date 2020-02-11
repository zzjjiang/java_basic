package com.zzj.proxy.myProxy;

/*
* 被代理实例
* */
public class Xiaoming implements People {

    //1、在小明双手没有解放之前，小明的父母要帮助小明找到对象

    @Override
    public void zhaoduixiang() {
        System.out.println("我在北京工作，没有时间找对象，双手一直得不到解放！！");
    }

    //2、如果小明的父母帮助小明找到了对象，小明可以解放双手，结婚生小孩
}
