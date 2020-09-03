package com.zzj.designpattern.creationalpattern.factory.simplefactory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 简单工程根据不同的参数类型返回不同的实例
 * 该类为工厂类
 * @createTime 2020年04月07日 22:08
 */
public class LoginManage {
    public static Login factory(String type){
        if("password".equals(type)){
            return new PasswordLogin();
        }else if("passcode".equals(type)){
            return new DomainLogin();
        }else {
            throw new RuntimeException("类型不存在");
        }
    }
}
