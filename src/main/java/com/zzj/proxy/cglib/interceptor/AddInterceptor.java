package com.zzj.proxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AddInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("add ----  before");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("add ----  after");
        return object;
    }
}
