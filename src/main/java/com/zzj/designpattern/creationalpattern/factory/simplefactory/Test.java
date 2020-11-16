package com.zzj.designpattern.creationalpattern.factory.simplefactory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 简单工厂测试
 * @createTime 2020年04月07日 22:19
 */
public class Test {
    public static void main(String[] args) {
        String loginType = "password";
        String name = "name";
        String password = "password";
        Login login = LoginManage.factory(loginType);
        boolean bool = login.verify(name, password);
        if (bool) {
            /**
             * 业务逻辑
             */
        } else {
            /**
             * 业务逻辑
             */
        }
    }

    /**
     * 重复代码多
     */
    public void origin() {

        String loginType = "password";
        String name = "name";
        String password = "password";
        //处理口令认证
        if(loginType.equals("password")){
            PasswordLogin passwordLogin = new PasswordLogin();
            boolean bool = passwordLogin.verify(name, password);
            if (bool) {
                //业务逻辑


            } else {
                //业务逻辑


            }
        }
        //处理域认证
        else if(loginType.equals("passcode")){
            DomainLogin domainLogin = new DomainLogin();
            boolean bool = domainLogin.verify(name, password);
            if (bool) {
                //业务逻辑


            } else {

                //业务逻辑
            }
        }else{
            // 业务逻辑
        }
    }
}



