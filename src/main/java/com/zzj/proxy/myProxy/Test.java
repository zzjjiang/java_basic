package com.zzj.proxy.myProxy;

public class Test {
    public static void main(String[] args) {
        People o = (People)MyProxy.newProxyInstance(Test.class.getClassLoader(),
                new Class<?>[]{People.class}, new Parent(new Xiaoming()));

        try {
            o.zhaoduixiang();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
