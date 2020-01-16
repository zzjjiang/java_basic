package com.zzj.timetest;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/3 19:43
 * @since JDK 1.8
 */
public class TimeCompareDemo {
	private static LocalDateTime now = LocalDateTime.now();

	@Test
	public void test() {
		int status = TimeCompareDemo.getStatus("19:42", "19:44");
		System.out.println(status);
		System.out.println(now);
	}

	@Test
	public void testTimeStamp() {
		Long timestamp = getTimestamp("6:00", "8:00");
		long a = System.currentTimeMillis();
		long b = getLocalDateTime("8:00").toInstant(ZoneOffset.of("+8")).toEpochMilli();
		System.out.println(timestamp);
		System.out.println(a - b);
	}

	private static Integer getStatus(String start, String end) {
		LocalDateTime startDateTime = getLocalDateTime(start);
		LocalDateTime endDateTime = getLocalDateTime(end);
		if (now.isBefore(startDateTime)) {
			return 1;
		} else if (now.isBefore(endDateTime)) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * 获取打卡开始时间和结束时间之间的时间戳，用于倒计时
	 */
	private static Long getTimestamp(String start, String end) {
		LocalDateTime startDateTime = getLocalDateTime(start);
		LocalDateTime endDateTime = getLocalDateTime(end);
		return endDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() - startDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

	/**
	 * 将字符串为 HH:mm 转换成时间
	 */
	private static LocalDateTime getLocalDateTime(String timeStr) {
		String[] times = timeStr.split(":");
		LocalTime time = LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
		LocalDate date = LocalDate.now();
		return LocalDateTime.of(date, time);
	}
}
