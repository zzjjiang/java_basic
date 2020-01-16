package com.zzj.Listtest;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/1 18:18
 * @since JDK 1.8
 */
public class ListDemo {
	@Test
	public void ytest() {
		List<Integer> userIds = new ArrayList<>();
		userIds.add(1);
		userIds.add(2);
		userIds.add(3);
		userIds.add(4);
		userIds = userIds.subList(0, 2);
		System.out.println(userIds.size());
		System.out.println(userIds.get(1));
	}
}
