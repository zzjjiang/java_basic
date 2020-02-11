package com.zzj.reflect;

import org.junit.Test;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
