package com.wwq.lamadaTest;

import com.alibaba.fastjson.JSONObject;
import com.wwq.lamadaTest.info.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class LambdaTest {

    @Test
    public void test(){
        Integer [] a = {1,3,2,4,6,5,3};
        List<Integer> ls = Arrays.asList(a);
        List<Integer> collect = ls.stream().filter(c -> c >= 4).map(d -> {if(d==4){return  4;}else{ return  d*d;}}).sorted((a1,a2) -> Integer.compare(a1,a2)).collect(Collectors.toList());
        ls.forEach(System.out::print);
        System.out.println("");
        collect.forEach(System.out::print);
    }
    @Test
    public void mapTest(){
        Map<String,Integer> map = new HashMap<>(4);
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        map.put("f",6);

        System.out.println(map.toString());
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(collect);

    }
    @Test
    public void groupingByTest(){

        User user1 = new User(1,"张三","13399999999","男","1990-01-01");
        User user2 = new User(2,"李四","13399999999","男","1995-02-02");
        User user3 = new User(3,"王五","14499999999","男","1990-02-02");
        User user4 = new User(4,"赵六","14499999999","女","1995-01-01");
        User user5 = new User(5,"周七","15599999999","女","1990-03-03");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
        // 分组
        // 按照性别分组：
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(user -> user.getSex()));
        String s = JSONObject.toJSON(collect).toString();
        System.out.println(s);
        // 按照多个属性分组
        Map<String, List<User>> collect1 = users.stream().collect(Collectors.groupingBy(user -> user.getSex() + user.getAge().substring(0, 4)));
        String s1 = JSONObject.toJSON(collect1).toString();
        System.out.println(s1);
        // 按照不同条件分组
        Map<String, List<User>> collect2 = users.stream().collect(Collectors.groupingBy(user -> {
            String age = user.getAge();
            int ageInt = Integer.parseInt(age.substring(0, 4));
            if (ageInt > 1990) {
                return "1990";
            } else {
                return "other";
            }
        }));
        String s2 = JSONObject.toJSON(collect2).toString();
        System.out.println(s2);
        // 多级分组
        Map<String, Map<String, List<User>>> collect3 = users.stream().collect(Collectors.groupingBy(user -> user.getSex(), Collectors.groupingBy(user -> user.getAge().substring(0, 4))));
        String s3 = JSONObject.toJSON(collect3).toString();
        System.out.println(s3);

        // 分组求和
        Map<String, Integer> collect4 = users.stream().collect(Collectors.groupingBy(user -> user.getSex(), Collectors.summingInt(user -> user.getId())));
        String s4 = JSONObject.toJSON(collect4).toString();
        System.out.println(s4);
        // 分组统计
        Map<String, Long> collect5 = users.stream().collect(Collectors.groupingBy(user -> user.getSex(), Collectors.counting()));
        String s5 = JSONObject.toJSON(collect5).toString();
        System.out.println(s5);

    }

    @Test
    public void maxTest() {
        Map<Integer, Long> countMap = new HashMap();
        countMap.put(1,12L);
        countMap.put(2,14L);
        countMap.put(3,13L);
        Optional<Map.Entry<Integer, Long>> max = countMap.entrySet().stream().max(Map.Entry.comparingByValue());
        if (max.isPresent()) {
            System.out.println(max.get());
        }
    }


}
