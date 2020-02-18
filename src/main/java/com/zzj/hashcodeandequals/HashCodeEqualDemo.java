package com.zzj.hashcodeandequals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jone
 * @version 1.0.0
 * @Description
 * @createTime 2020年02月15日 16:09
 *
 * 在Java API文档中关于hashCode方法有以下几点规定:
 *  如果两个对象通过调用equals方法是相等的，那么这两个对象调用hashCode方法必须返回相同的整数。
 *  如果两个对象通过调用equals方法是不相等的，不要求这两个对象调用hashCode方法必须返回不同的整数。
 */
public class HashCodeEqualDemo {

    public static void main(String[] args) {
        //key操作的是hash值
        Map keyMap = new HashMap(16);
        Key key1 = new Key("11");
        Key key2 = new Key("11");
        keyMap.put(key1, "12");
        System.out.println(keyMap.get(key2));
        System.out.println("12".equals(keyMap.get(key2)));

        Map valMap = new HashMap(16);
        Val val1 = new Val("99");
        Val val2 = new Val("99");
        valMap.put(val1,"12");
        System.out.println(valMap.get(val2));
        System.out.println("12".equals(valMap.get(val2)));
    }
}

class Key {
    private String name;

    public Key(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

class Val {
    private String name;

    public Val(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 如果在子类中重新定义equals，就要在其中包含调用super.equals(other)
     * 当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明 相等对象必须具有相等的哈希码 。
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Val)) {
            return false;
        }
        Val val = (Val) o;
        return getName().equals(val.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}