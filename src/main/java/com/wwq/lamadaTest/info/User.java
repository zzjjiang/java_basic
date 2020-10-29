package com.wwq.lamadaTest.info;

/**
 * 用户
 * @author william_wu
 */
public class User {

    private Integer id;
    private String name;
    private String phone;
    private String sex;
    private String age;

    public User(Integer id, String name, String phone, String sex,String age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
