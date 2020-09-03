package com.zzj.Listtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/1 18:18
 * @since JDK 1.8
 */
public class ListDemo {
	@Test
	public void subListTest() {
		List<Integer> userIds = new ArrayList<>();
		userIds.add(1);
		userIds.add(2);
		userIds.add(3);
		userIds.add(4);
		userIds = userIds.subList(0, 2);
		System.out.println(userIds.size());
		System.out.println(userIds.get(1));
	}

	@Test
	public void test(){
		List<Integer> one = new ArrayList<>();
		System.out.println(one.get(0));
		System.out.println(one.size());
		List<Object> tow = new ArrayList<>();
		System.out.println(tow.size());
	}
}
