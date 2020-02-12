package com.zzj.reflect.ext.factory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description service子类
 * @createTime 2020年02月12日 14:09
 */
public class MyService implements IService {
    @Override
    public void print(){
        System.out.println("my service ");
    }
}
