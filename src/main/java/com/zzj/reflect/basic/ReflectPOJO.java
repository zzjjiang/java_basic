package com.zzj.reflect.basic;

public class ReflectPOJO{

    @MyAnnotation(value = "zzj")
    private String name;

    private Integer age;

    private int grade;

    private ReflectParent parent;

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

    public ReflectParent getParent() {
        return parent;
    }

    public void setParent(ReflectParent parent) {
        this.parent = parent;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
