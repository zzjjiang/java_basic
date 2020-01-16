package com.zzj.staticDemo;

import java.time.LocalDateTime;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/4 15:41
 * @since JDK 1.8
 */
public class StaticDemo {
	private static LocalDateTime dateTime = LocalDateTime.now();

	public static void main(String[] args) {
		System.out.println("1--" + dateTime);
		System.out.println("2--" + dateTime);
		System.out.println("3--" + dateTime);
		System.out.println("4--" + dateTime);
	}
}
