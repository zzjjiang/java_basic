package com.zzj.javaversion.java8.timetest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/10/30 18:55
 * @since JDK 1.8
 */
public class LocaldateTest {
	private static LocalDateTime currentTime = LocalDateTime.now();

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDateTime now1 = LocalDateTime.now();
		LocalTime time = LocalTime.of(3, 50);
		LocalDateTime dateTime = LocalDateTime.of(now, time);
		System.out.println(dateTime);
		System.out.println(dateTime.compareTo(now1));

		LocalTime time1 = LocalTime.of(23, 50, 0);
		LocalDateTime dateTime1 = LocalDateTime.of(now, time1);
		System.out.println(dateTime1);
	}

	/**
	 * localDateTime 转换成对应的字符串类型
	 */
	@Test
	public void test() {
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}

	/**
	 * 获取时间戳
	 */
	@Test
	public void test2() {
		System.out.println(currentTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	}


	/**
	 * 根据时间戳 转换成对应的时间
	 */
	@Test
	public void test4() {
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		LocalDateTime localDateTime = Instant.ofEpochMilli(1577203200000L).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
		System.out.println(localDateTime);
	}
	/**
	 * 获取昨天日期
	 */
	@Test
	public void test5(){
		String format = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(format);
	}

	@Test
	public void test6(){
		String s = LocalDate.of(2020,8,24).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		LocalDate s1 = LocalDate.of(2020,8,24);
		LocalDate s2 = LocalDate.of(2020,9,25);
		LocalDate parse1 = LocalDate.parse("2020-08-24",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate parse2 = LocalDate.parse("2020-09-24",DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		System.out.println(ChronoUnit.DAYS.between(parse1, parse2));
	}


	@Test
	public void test7(){
		String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(s);
		System.out.println(s.substring(0,10));
	}
}
