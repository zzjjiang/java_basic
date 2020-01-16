package com.zzj.timetest;

import org.apache.commons.lang3.time.DateUtils;
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

	@Test
	public void test() {
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void test2() {
		Long stamp = getTimestamp("10:40");
		System.out.println(stamp);
		System.out.println(currentTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
	}

	private Long getTimestamp(String time) {
		LocalDateTime dateTime = getLocalDateTime(time);
		return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

	public static LocalDateTime getLocalDateTime(String timeStr) {
		String[] times = timeStr.split(":");
		LocalTime time = LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
		LocalDate date = LocalDate.now();
		return LocalDateTime.of(date, time);
	}

	@Test
	public void test3() {
		String s = "2019-11-01 09:44:07.0";
		String s1 = s.substring(11, 19);
		System.out.println("--" + s1);

	}

	@Test
	public void test4() {
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		LocalDateTime localDateTime = Instant.ofEpochMilli(1577203200000L).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();

		System.out.println(localDateTime);
	}
}
