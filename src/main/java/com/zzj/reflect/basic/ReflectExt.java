package com.zzj.reflect.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 反射实例化对象  通过set get方式 method调用setter方法是自己拼接的
 * 级联类处理的时候注意currentObj的细节，重要，最后设置属性的时候是通过改对象来操作的
 * @createTime 2020年02月13日 00:49
 */
public class ReflectExt {
    public static void main(String[] args) throws Exception {
        String props = "name:jone|age:17|grade:8|parent.pname:yy";
        String[] splits = props.split("\\|");
        //获取reflectPojo，全部属性
        Class<ReflectPOJO> clazz = ReflectPOJO.class;
        //实例化对象
        ReflectPOJO pojo = clazz.getDeclaredConstructor().newInstance();
        for (String ss:splits) {
            String[] split = ss.split(":");
            if(split[0].contains(".")){
                //该处为类类型
                String[] ps = split[0].split("\\.");
                Object currentObj = null;
                for (int i = 0; i < ps.length - 1; i++) {
                    Method method = clazz.getDeclaredMethod("get"+getUName(ps[i]));
                    Object tempObj = method.invoke(pojo);
                    if(tempObj == null){
                        Field field = clazz.getDeclaredField(ps[0]);
                        Method setMethod = clazz.getDeclaredMethod("set"+getUName(ps[i]),field.getType());
                        Object newObj = field.getType().getDeclaredConstructor().newInstance();
                        setMethod.invoke(pojo,newObj);
                        currentObj = newObj;
                    }else{
                        currentObj=tempObj;
                    }
                }
                Field field = currentObj.getClass().getDeclaredField(ps[ps.length-1]);
                Method method = currentObj.getClass().getDeclaredMethod("set" + getUName(field.getName()), field.getType());
                Object arg = getMyArg(split[1],field.getType().getName());
                method.invoke(currentObj,arg);
            }else{
                Field field = clazz.getDeclaredField(split[0]);
                Method method = clazz.getDeclaredMethod("set" + getUName(field.getName()), field.getType());
                Object arg = getMyArg(split[1],field.getType().getName());
                method.invoke(pojo,arg);
            }

        }


        //取值
        System.out.println(pojo.getName());
        System.out.println("--"+pojo.getParent().getPname());
    }

    /**
     * @title getName
     * @description 将首字母大写
     * @author Jone
     * @updateTime 2020/2/13 1:02 上午
     * @throws
     */
    public static String getUName(String filedName){
        return filedName.substring(0,1).toUpperCase()+filedName.substring(1);
    }
    /**
     * @title getMyArg
     * @description 处理反射的method.invoke 参数类型
     * @author Jone
     * @updateTime 2020/2/13 2:47 上午
     * @throws
     */
    public static Object getMyArg(String value, String type){
        System.out.println(type);
        if("java.lang.Integer".equals(type) || "int".equals(type)){
            return Integer.parseInt(value);
        }else{
            return value;
        }

    }
}
