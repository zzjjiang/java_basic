package com.zzj.fastjsonTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/21 10:49
 * @since JDK 1.8
 */
public class JsonTest {

	@Test
	public void test() {
		System.out.println(getMonthTimestamp("2019-11"));
	}

	@Test
	public void test1() {
		LocalDate now = LocalDate.now();
		int dayOfMonth = now.getDayOfMonth();
		System.out.println(dayOfMonth);
	}

	private static Long getMonthTimestamp(String date) {
		String[] dates = date.split("-");
		LocalDate localDate = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), 1);
		LocalTime localTime = LocalTime.of(0, 0);
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
	}

}
