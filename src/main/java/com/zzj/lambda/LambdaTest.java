package com.zzj.lambda;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/22 17:57
 * @since JDK 1.8
 */
public class LambdaTest {
	@Test
	public void test() {
		Usel user1 = new Usel(1, "张三", "小学", "2019-11-22 18:30:22", 1);
		Usel user2 = new Usel(2, "李四", "小学", "2019-11-22 18:10:22", 0);
		Usel user3 = new Usel(3, "王五", "初中", "2019-11-23 18:20:22", 1);
		Usel user4 = new Usel(4, "马六", "高中", "2019-11-23 18:40:22", 0);
		Usel user5 = new Usel(5, "jack", "大学", "2019-11-23 18:50:22", 0);
		List<Usel> usels = Arrays.asList(user1, user2, user3, user4, user5);
		System.out.println(usels.size());

		Map<String, List<Usel>> mapOne = usels.stream().collect(Collectors.groupingBy(usel -> {
					String s = usel.getDate().substring(0, 10);

					LocalDateTime timeMax = LocalDateTime.of(LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.MAX);
					LocalDateTime timeMin = LocalDateTime.of(LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.MIN);
					if (LocalDateTime.parse(usel.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).isBefore(timeMax)
							&& LocalDateTime.parse(usel.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).isAfter(timeMin)) {
						return s;
					}
					return "";
				}
		));

		String s = JSON.toJSONString(mapOne);
		System.out.println(s);
	}


	@Test
	public void test2() {
		Map<Integer, Long> countMap = new HashMap();
		//countMap.put(1,2L);
		//countMap.put(2,2L);
		Optional<Map.Entry<Integer, Long>> max = countMap.entrySet().stream().max(Map.Entry.comparingByValue());
		if (max.isPresent()) {
			System.out.println(max.get());
		}
	}

	@Test
	public void test3() {
		List<String> s = new ArrayList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		s.add("10");
		s.add("11");
		List<String> strings = s.stream().sorted().collect(toList());
		System.out.println(JSON.toJSONString(strings));

		List<Integer> s1 = new ArrayList<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(10);
		s1.add(11);
		List<Integer> strings1 = s1.stream().sorted().collect(toList());
		System.out.println(JSON.toJSONString(strings1));
	}

	@Test
	public void test4() {

		UseTow useTow1 = new UseTow(1, 1, 3);
		UseTow useTow2 = new UseTow(2, 2, 3);
		UseTow useTow3 = new UseTow(3, 3, 3);
		UseTow useTow4 = new UseTow(4, 1, 4);
		UseTow useTow5 = new UseTow(5, 2, 4);
		UseTow useTow6 = new UseTow(6, 3, 4);
		UseTow useTow7 = new UseTow(7, 2, 5);
		UseTow useTow8 = new UseTow(8, 2, 5);
		List<UseTow> useTows = Arrays.asList(useTow1, useTow2, useTow3, useTow4, useTow5, useTow6, useTow7, useTow8);
		Map<Integer, List<Integer>> collect = useTows.stream().collect(Collectors.groupingBy(UseTow::getPosterId, Collectors.mapping(UseTow::getTagId, toList())));
		System.out.println(JSON.toJSONString(collect));
	}

	@Test
	public void test5() {
		Map<Integer, String> materialMap = new HashMap<>();
		System.out.println(materialMap.get("11"));
	}

	@Test
	public void test6() {
		//UseTow useTow = new UseTow(1, 0, 3);
		//useTow = new UseTow(2, 1, 3);
		//useTow = new UseTow(3, 1, 3);
		//useTow = new UseTow(4, 2, 4);
		//useTow = new UseTow(5, 3, 4);
		//useTow = new UseTow(6, 4, 4);
		//useTow = new UseTow(7, 6, 5);
		UseTow useTow = new UseTow(8, 7, 5);
		while (useTow.getTagId() != 0) {
			System.out.println(useTow.getTagId());
			useTow = new UseTow(1, 0, 3);
		}
		System.out.println("out--" + useTow.getTagId());
	}

	@Test
	public void test7() {

		List<Integer> s1 = new ArrayList<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(10);
		s1.add(11);
		if (s1.contains(2)) {
			System.out.println("17");
		}
	}

	@Test
	public void test8() {
		int n = 6;
		String s = "abc";
		System.out.println("%1$0" + (n - s.length()) + "d");
		System.out.println();
	}

	@Test
	public void test9() {
		List<String> list = Arrays.asList("hello", "world");
		List<String> collect = list.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		System.out.println(JSON.toJSONString(collect));
	}

}
