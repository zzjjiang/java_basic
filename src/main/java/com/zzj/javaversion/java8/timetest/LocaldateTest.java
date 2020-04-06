package com.zzj.javaversion.java8.timetest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

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
}
