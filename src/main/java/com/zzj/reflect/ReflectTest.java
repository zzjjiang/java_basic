package com.zzj.reflect;

import org.junit.Test;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 区别一
 *
 * 　　在方法名末尾有s的是返回一个数组，没有s的是返回单个构造器。
 *
 * 区别二
 *
 * 　　在方法名中加Declared的是返回所有的构造方法，不加Declared的只返回public访问权限的构造器
 *
 * 区别三
 *
 * 　　有参数的都是在方法名中没有在结尾处加s的，返回的是指定参数类型的构造器
 *
 *
 *
 * 总结：反射机制中，所有添加Declared的获取方式都是暴力获取所有构造（或方法，或字段），通过暴力获取的字段我们在进行访问的时候需要进行可访问性设置，即
 *
 */
public class ReflectTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Class<ReflectPOJO> clazz = ReflectPOJO.class;
        System.out.println(clazz);
        ClassLoader loader = clazz.getClassLoader();
        System.out.println(loader);
        String name = clazz.getName();
        System.out.println(name);


        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method:
        declaredMethods) {
            System.out.println(method.getName() + "---" + method.getReturnType());
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            System.out.println(field.isAnnotationPresent(Resource.class));
            System.out.println(field.getType() + "---" + field.getName());

        }

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation:
             declaredAnnotations) {
            System.out.println(annotation);
        }
         Constructor<?>[] constructors = clazz.getConstructors();
//        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor:
             constructors) {
            System.out.println(constructor);
        }


        ReflectPOJO pojo = new ReflectPOJO("zzj",24);
        Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(pojo));

    }
}
