package com.zzj.java8.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jone
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月30日 23:57
 */
public class hashMapOrder {
    public static void main(String[] args) {

        Map<String, Integer> valueResult = new LinkedHashMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("hn",20);
        map.put("gx",40);
        map.put("sx",30);
        map.put("yn",10);
        map.put("xj",30);
        map.put("hb",40);
        map.put("bj",50);
        map.put("zj",20);
        System.out.println(map.toString());
        map.entrySet().stream()
                .sorted(Map.Entry
                        .comparingByValue(Comparator.reverseOrder())).limit(4)
                .forEachOrdered(b->valueResult.put(b.getKey(), b.getValue()));
        System.out.println(valueResult.toString());


        List<String> list = valueResult.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(list);
    }
}
