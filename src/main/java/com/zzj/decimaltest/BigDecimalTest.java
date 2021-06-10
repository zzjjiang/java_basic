package com.zzj.decimaltest;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/1 11:43
 * @since JDK 1.8
 */

public class BigDecimalTest {
	@Test
	public void testDiv() {
//		BigDecimal punchRate = new BigDecimal(1).divide(new BigDecimal(3),2,BigDecimal.ROUND_HALF_UP);
//		System.out.println(punchRate);
		BigDecimal punchRate = new BigDecimal(1).divide(new BigDecimal(3), 2, BigDecimal.ROUND_HALF_UP);
		System.out.println(punchRate);
	}

	@Test
	public void test2() {
		BigDecimal multiply = new BigDecimal(1).multiply(new BigDecimal(0.01));
		System.out.println(multiply);
	}


	@Test
	public void test3() {
		BigDecimal c1=new BigDecimal("0.230+		11");
		BigDecimal result;

		result = c1.setScale(2,BigDecimal.ROUND_UP);
		System.out.println("ROUND_UP" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_DOWN);
		System.out.println("ROUND_DOWN" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_CEILING);
		System.out.println("ROUND_CEILING" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_FLOOR);
		System.out.println("ROUND_FLOOR" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("ROUND_HALF_UP" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		System.out.println("ROUND_HALF_DOWN" + result.toString());

		result = c1.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		System.out.println("ROUND_HAIL_EVEN" + result.toString());
	}
}
