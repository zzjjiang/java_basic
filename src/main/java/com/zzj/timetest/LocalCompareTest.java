package com.zzj.timetest;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/11 11:18
 * @since JDK 1.8
 */
public class LocalCompareTest {
	@Test
	public void test1() {
//2019-11-11 17:26:40.0   sql return
//2019-11-11T11:27:31.994 LocalDateTime
		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(now);
		String time = "2019-11-11 11:35:50.0";
		String s = time.substring(0, 19);
		System.out.println(s);
		if (now.equals(s)) {
			System.out.println("is ok");
		}
	}
}
