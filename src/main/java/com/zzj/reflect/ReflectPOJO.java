package com.zzj.reflect;

import javax.annotation.Resource;

public class ReflectPOJO{

    @Resource
    private String name  = "jone";

    private Integer age = 17;

    private ReflectPOJO(){
        System.out.println("no");
    }

    public ReflectPOJO(String name,Integer age){
        this.name = name;
        this.age = age;
        System.out.println("tow");
    }

    public void test(){
        System.out.println("test");
    }


    public void testName(String name){
        System.out.println("test name");
    }

    public int testAge(Integer age){
        System.out.println("test age");
        return age;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
