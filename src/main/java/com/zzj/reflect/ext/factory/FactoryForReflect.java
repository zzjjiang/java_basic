package com.zzj.reflect.ext.factory;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 工厂模式通过反射优化   无论什么接口和实例都能在此实现
 * @createTime 2020年02月12日 13:52
 */
public class FactoryForReflect {

    private FactoryForReflect(){}

    /**
     * Class<String> clz = String.class;
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className,Class<T> clazz){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }


}
