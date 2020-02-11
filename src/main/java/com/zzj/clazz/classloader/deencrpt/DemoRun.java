package com.zzj.clazz.classloader.deencrpt;

public class DemoRun {

    public static void main(String[] args) throws Exception {
        System.out.println("11");
        //new出自定义类加载器
        CustomClassLoader demoCustomClassLoader = new CustomClassLoader("My ClassLoader");
        //设置加载类的路径
        demoCustomClassLoader.setBasePath("/Users/zujiangzou/Desktop/jone/test/target/classes/");
        Class<?> clazz = demoCustomClassLoader.findClass("com.zzj.clazz.classloader.deencrpt.DemoUser");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
        System.out.println(o);



    }
}
