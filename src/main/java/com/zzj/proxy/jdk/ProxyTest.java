package com.zzj.proxy.jdk;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        People people = (People) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{People.class}, new BlackJack(new XiaoJone()));
        people.findOne();
    }
}
