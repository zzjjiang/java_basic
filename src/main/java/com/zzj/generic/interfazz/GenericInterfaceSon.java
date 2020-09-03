package com.zzj.generic.interfazz;

/**
 * @author zzj
 * @description 未传入泛型实参时，子类的
 * @date 2020.09.03
 */
public class GenericInterfaceSon<T> implements GenericInterfaceDemo <T>{

    @Override
    public T test() {
        return null;
    }
}
