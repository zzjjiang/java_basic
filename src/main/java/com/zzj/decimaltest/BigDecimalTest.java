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

}
