package com.zzj.proxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class QueryInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("query---- before");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("query---- after");
        return object;
    }
}
