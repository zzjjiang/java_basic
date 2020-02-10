package com.zzj.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class MyCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        String methodName = method.getName();
        if("add".equals(methodName)){
            return 0;
        }else if ("del".equals(methodName)){
            return 1;
        }else if("query".equals(methodName)){
            return 2;
        }else {
            return 3;
        }
    }
}
