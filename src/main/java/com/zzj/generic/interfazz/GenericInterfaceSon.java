package com.zzj.generic.interfazz;

/**
 * @author zzj
 * @description 实现泛型接口的类，未传入泛型实参时，子类与泛型类的定义相同
 * @date 2020.09.03
 */
public class GenericInterfaceSon<T> implements GenericInterfaceDemo <T>{

    @Override
    public T test() {

        return null;
    }
}
/*
    other 传入泛型类的定义
public class GenericInterfaceSon implements GenericInterfaceDemo <String>{

    @Override
    public T test() {
        return null;
    }
}
 */