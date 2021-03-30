package com.zzj.javaversion.java8.lambda;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void groupingByTest() {
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
	public void groupingBy() {

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
	public void maxTest() {
		Map<Integer, Long> countMap = new HashMap();
		Optional<Map.Entry<Integer, Long>> max = countMap.entrySet().stream().max(Map.Entry.comparingByValue());
		if (max.isPresent()) {
			System.out.println(max.get());
		}
	}

	@Test
	public void sortedTest() {
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
	public void test66() throws Exception {
		String start = "2021-01-25 19:50:11";
		String end = "2022-03-25 19:50:11";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);

		DateTime dateTime = DateUtil.beginOfMonth(startDate);
		System.out.println(dateTime);
		DateTime month = DateUtil.offsetMonth(dateTime, 1);
		System.out.println(month);

		long betweenMonth = DateUtil.betweenMonth(startDate, endDate, true);
		System.out.println(betweenMonth);
	}

	@Test
	public void ziranyue() throws ParseException {
		String start = "2021-01-25 19:50:11";
		String end = "2021-03-25 19:50:11";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);

		Stream.iterate(DateUtil.beginOfMonth(startDate),
				date -> DateUtil.offsetMonth(date, 1))
				.limit(DateUtil.betweenMonth(startDate, endDate, true) + 1)
				.forEach(date ->
						System.out.println(date));
//		System.out.println(DateUtil.offsetDay(DateUtil
//								.offsetMonth(dateTime, 1), -1)));
	}

	@Test
	public void hetongyue() throws ParseException {
		String start = "2021-01-25 19:50:11";
		String end = "2021-03-25 19:50:11";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);

		Stream.iterate(startDate,
				date -> DateUtil.offsetMonth(date, 1))
				.limit(DateUtil.betweenMonth(startDate, endDate, false) + 1)
				.forEach(dateTime ->
						System.out.println(DateUtil.offsetDay(DateUtil
								.offsetMonth(dateTime, 1), -1)));
	}

	@Test
	public void jidu() throws ParseException {
		String start = "2021-01-25 19:50:11";
		String end = "2021-07-25 19:50:11";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
		long years = DateUtil.betweenYear(startDate, endDate, true);
		int quarter1 = DateUtil.quarter(startDate);
		System.out.println("quarter1--" + quarter1);
		int quarter2 = DateUtil.quarter(endDate);
		System.out.println("quarter2--" + quarter2);
		Stream.iterate(DateUtil.beginOfQuarter(startDate),
				date -> DateUtil.offsetMonth(date, 3))
				.limit(years * 4 + (quarter2 - quarter1 + 1))
				.forEach(date -> System.out.println(date));
	}

}
