package com.zzj.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BlackJack implements InvocationHandler {
    private People people;
    public BlackJack(People people){
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(people,null);
        after();
        return null;
    }

    public void before(){
        System.out.println("this is before");
    }

    public void after(){
        System.out.println("this is after");
    }
}
