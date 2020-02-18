package com.zzj.io.stream.ext.objectstream;

import java.io.*;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 对象序列化
 * @createTime 2020年02月14日 16:26
 */
public class ObjectStreamDemo {
    private static final String CLASS_PATH = "/Users/zujiangzou/Desktop/demotest/serial.person";

    public static void main(String[] args) {
        Person yy = new Person("yy", "17");
        try {
            saveObj(yy);
            Object o = loadObj();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化
     * @param obj
     * @throws Exception
     */
    public static void saveObj(Object obj) throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(CLASS_PATH)));
        os.writeObject(obj);
        os.close();
    }

    /**
     * 反序列化
     * @return
     * @throws Exception
     */
    public static Object loadObj() throws Exception {
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(new File(CLASS_PATH)));
        Object obj = ois.readObject();
        ois.close();
        return obj;

    }

}

/**
 * 要想序列化必须实现serializable接口
 */
class Person implements Serializable{
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}