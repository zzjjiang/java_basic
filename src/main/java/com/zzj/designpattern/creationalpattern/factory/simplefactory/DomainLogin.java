package com.zzj.designpattern.creationalpattern.factory.simplefactory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 具体产品域名登录
 * @createTime 2020年04月07日 22:14
 */
public class DomainLogin implements Login{
    @Override
    public boolean verify(String name, String password) {
        return false;
    }
}
