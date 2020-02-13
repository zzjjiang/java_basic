package com.zzj.reflect.ext.other;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
@FunctionalInterface//程序执行时可以获取
@Deprecated//程序执行时可以获取
interface IMessage {//有2个Annotation
    void send(String message);
}
@SuppressWarnings("serial")//该Annotation无法在程序执行时获取
class MessageImpl implements IMessage, Serializable {
    @Override//无法在程序执行时获取
    public void send(String message) {
        System.out.println("【消息发送】" + message);
    }
}
public class JavaAPIDemo {
    public static void main(String[] args) throws Exception {
//        {//获取IMessage接口上的Annotation信息
//            Annotation[] annotations = IMessage.class.getAnnotations();//获取接口上的全部Annotation
//            for (Annotation annotation : annotations) {
//                System.out.println(annotation);
//                //@java.lang.FunctionalInterface()
//                //@java.lang.Deprecated(forRemoval=false, since="1.0")
//            }
//        }
        System.out.println("-----------------------");
        {//获取MessageImpl类上的Annotation信息
            Annotation[] annotations = MessageImpl.class.getAnnotations();//获取类上的全部Annotation
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
        System.out.println("-----------------------");
        {//获取MessageImpl.send()方法上的Annotation信息
            Method method = MessageImpl.class.getDeclaredMethod("send", String.class);
            Annotation[] annotations = method.getAnnotations();//获取方法上的全部Annotation
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }
}