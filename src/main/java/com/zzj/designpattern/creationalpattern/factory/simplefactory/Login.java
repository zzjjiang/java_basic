package com.zzj.designpattern.creationalpattern.factory.simplefactory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 抽象产品
 * @createTime 2020年04月07日 22:12
 */
public interface Login {
    boolean verify(String name,String password);
}
