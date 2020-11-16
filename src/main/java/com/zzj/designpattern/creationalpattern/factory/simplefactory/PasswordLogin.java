package com.zzj.designpattern.creationalpattern.factory.simplefactory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 具体的密码登录产品
 * @createTime 2020年04月07日 22:14
 */
public class PasswordLogin implements Login{
    @Override
    public boolean verify(String name, String password) {
        return false;
    }
}
