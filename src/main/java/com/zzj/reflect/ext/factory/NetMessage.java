package com.zzj.reflect.ext.factory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description message实现子类
 * @createTime 2020年02月12日 14:02
 */
public class NetMessage implements IMessage {

    @Override
    public void print(){
        System.out.println("net message");
    }
}
