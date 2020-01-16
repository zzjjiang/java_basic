package com.zzj.timetest;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/11 15:07
 * @since JDK 1.8
 */
public class ShowTImeTest {
	/**
	 * 今天内
	 * 今天 N点N分
	 * <p>
	 * 明天内
	 * 明天 N点N分
	 * <p>
	 * 今年内
	 * N月N日
	 * <p>
	 * 今年以后
	 * N年N月N日
	 *
	 * @param time 格式： 2019-10-17 10:10:10
	 * @return java.lang.String
	 */
	public static String getPartyTime(String time) {

		LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		LocalDateTime now = LocalDateTime.now();
		long dateTimeMills = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		long nowMills = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		//秒
		long timeDiff = Math.abs(dateTimeMills - nowMills) / 1000;
		//天
		long dateDiff = timeDiff / 60 / 60 / 24;
		if (dateDiff == 0) {
			return "今天" + toString(dateTime, "HH:mm");
		} else if (dateDiff == 1) {
			return "明天" + toString(dateTime, "HH:mm");
		} else if (dateDiff <= 365) {
			return toString(dateTime, "MM月dd日 HH:mm");
		} else {
			return toString(dateTime, "yyyy年MM月dd日 HH:mm");
		}
	}

	/**
	 * 获取对应的时间显示规则
	 */
	public static String toString(LocalDateTime dateTime, String pattern) {
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	@Test
	public void test01() {
		System.out.println(getPartyTime("2019-11-13 15:51"));
	}

	@Test
	public void test02() {
//		LocalDateTime dateTime = LocalDateTime.parse("2019-11-11 15:51:00.0".substring(0,16), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.println("2019-11-11 15:51:00.0".substring(0, 16));
	}

}
