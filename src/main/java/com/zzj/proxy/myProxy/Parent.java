package com.zzj.proxy.myProxy;

import java.lang.reflect.Method;

/*
* 这个是一个增强类，是对目标对象的一个方法增强
* */
public class Parent implements MyInvocationHandler {

    private People people;

    public Parent(People people) {
        this.people = people;
    }

    /*
    * 帮助消息找到对象，
    * 找到对象以后，帮助小明操持婚礼，带消息
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object args) throws Throwable {

        //帮他找到对象
        before();

        //这个invoke就会掉到被代理类中的method
        method.invoke(people,null);


        after();

        return null;
    }

    /*
    *  这个方法是小明在找到对象之前，父母帮助他做得事情
    * */
    private void before() {
        System.out.println("我是小明的父母，我需要帮助小明找对象！！");
    }

    /*
    * 找到对象之前，父母帮助他操持婚礼，带小孩
    * */
    private void after() {
        System.out.println("我是小明的父母，我们需要帮助小明操持婚礼，帮他带小孩");
    }
}
