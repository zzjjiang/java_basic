package com.zzj.proxy.cglib;

import com.zzj.proxy.cglib.interceptor.AddInterceptor;
import com.zzj.proxy.cglib.interceptor.DelInterceptor;
import com.zzj.proxy.cglib.interceptor.QueryInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class CglibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallbackFilter(new MyCallbackFilter());
        NoOp noOp = NoOp.INSTANCE;
        enhancer.setCallbacks(new Callback[]{new AddInterceptor(),new DelInterceptor(),new QueryInterceptor(),noOp});
        enhancer.setSuperclass(TargetClass.class);
        TargetClass o = (TargetClass) enhancer.create();
        o.add();
    }
}
