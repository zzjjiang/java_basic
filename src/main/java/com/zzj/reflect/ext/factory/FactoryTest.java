package com.zzj.reflect.ext.factory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 测试类
 * @createTime 2020年02月12日 14:01
 */
public class FactoryTest {
    public static void main(String[] args) {
        IService iService = FactoryForReflect.getInstance("com.zzj.reflect.ext.factory.MyService", IService.class);
        iService.print();
    }
}
