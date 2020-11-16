package com.zzj.datastructure.linear;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jone
 * @version 1.0.0
 * @Description arrayList和linkedList使用
 * @createTime 2020年03月08日 10:21
 */
public class ListDemo {

    private static List<Integer> arrayList = new ArrayList();
    private static List<Integer> linkedList = new LinkedList();

    //添加
    public void add(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    //删除
    public void remove(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.remove(0);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    //查找
    public void get(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
       /* new ListDemo().add(arrayList);
        new ListDemo().add(linkedList);

        new ListDemo().get(arrayList);
        new ListDemo().get(linkedList);

        new ListDemo().remove(arrayList);
        new ListDemo().remove(linkedList);

        List list = new ArrayList();
        list.add(null);*/


        Map map = new HashMap<>(4);
        map.put("1",2);
        map.put("1",3);
        System.out.println(map.get("1"));

        new Hashtable<>();
        new HashSet();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }
}
