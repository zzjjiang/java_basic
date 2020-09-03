package com.zzj.generic.clazz;

/**
 * @author zzj
 * @description 泛型类
 * @date 2020.09.03
 */
public class GenericClassDemo <T>{

    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    public static void main(String[] args) {
        GenericClassDemo<Integer> classDemo = new GenericClassDemo<>();
        classDemo.setVar(1);
        System.out.println(classDemo.getVar());
    }
}

/*
    注意泛型类型只能是类类型，不能是基本类型
    class 类名称 <泛型标识:可以任意标识号，标识指定泛型的类型>{

        private 泛型标识 var;//变量
    }












 */