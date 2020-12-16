package com.zzj.Listtest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

	@Test
	public void testJiao(){
		String realPerms = "2,1";
		String ownPerms = "0,2,1,9,6";
		List<String> realList = Arrays.stream(realPerms.split(",")).collect(Collectors.toList());
		List<String> ownList = Arrays.stream(ownPerms.split(",")).collect(Collectors.toList());

		// List<String> ownList = Arrays.asList(ownPerms.split(","));
		ownList.retainAll(realList);
		System.out.println(JSON.toJSONString(ownList));
		System.out.println(String.join(",", ownList));
	}
}
