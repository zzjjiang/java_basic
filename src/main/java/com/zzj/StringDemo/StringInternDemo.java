package com.zzj.StringDemo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/10/23 9:39
 * @since JDK 1.8
 */
public class StringInternDemo {

	public static void main(String[] args) {
		String a = "demo";
		String b = "demo";
		String c = "demo";
	}

	@Test
	public void test() {
		String a = "2019-11-15 14:29:11";
		System.out.println(getType(a));

	}

	private static Integer getType(String endTime) {

		LocalDateTime stopTime = LocalDateTime.parse(endTime.substring(0, 16), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		if (stopTime.isBefore(LocalDateTime.now())) {
			return 1;
		}

		return 0;
	}

	@Test
	public void test1() {
		System.out.println(getDetailHref(12));
	}

	private static String getDetailHref(Integer partyId) {
		return "<a href='" + "http://act.test-mmsay.com" + "/h5/convention/index.html#/detailed?partyId=" + partyId + "'>查看详情></a>";

//		return "<a href="+ "http://act.test-mmsay.com" + "/h5/convention/index.html#/detailed?partyId="+partyId+">查看详情></a>";
	}
}
