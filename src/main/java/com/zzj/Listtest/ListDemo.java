package com.zzj.Listtest;

import com.alibaba.fastjson.JSON;
import com.zzj.test.TestVO;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

	@Test
	public void testList(){
		List<TestVO> optionList = new ArrayList<>();
		TestVO testVO1 = new TestVO();
		testVO1.setId("1");
		testVO1.setName("1name");
		optionList.add(testVO1);
		TestVO testVO2 = new TestVO();
		testVO2.setId("2");
		testVO2.setName("2name");
		optionList.add(testVO2);
		//去掉当前租户--->下拉
		optionList.removeIf(testVO -> "1".equals(testVO.getId()));
		System.out.println(JSON.toJSONString(optionList));
	}

	@Test
	public void testNull(){
		Long l = 1L;
		if(l.equals(null)){
			System.out.println("haha");
		}else{
			System.out.println("gaga");
		}

	}

	@Test
	public void testDate(){
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
		System.out.println(format);
		String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
		System.out.println(format1);

	}

	@Test
	public void subStrDate(){
		String format = "2021-03-04 10:40:00";
		System.out.println(format);
		String format1 = format.substring(0,10);
		System.out.println(format1);

	}
}
