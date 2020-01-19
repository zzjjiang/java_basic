package com.zzj.java8.lambda.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * <p>
 * Consumer<T> : 消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T> : 供给型接口
 * T get();
 * <p>
 * Function<T, R> : 函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T> : 断言型接口
 * boolean test(T t);
 * <p>
 * 方法引用  目标引用放在::(分隔符前)，方法的名称放在后面
 * (Apple apple) -> apple.getWeight();  --- Apple::getWeight
 *
 * @author Jone
 */
public class FunctionTest {
	//Predicate<T> t->boolean  断言型接口
	@Test
	public void predicateTest() {
		List<String> list = Arrays.asList("Hello", "tustman", "Lambda", "www", "ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);

		for (String str : strList) {
			System.out.println(str);
		}
	}

	//需求：将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<>();

		for (String str : list) {
			if (pre.test(str)) {
				strList.add(str);
			}
		}

		return strList;
	}

	//Function<T,R> 函数型接口:
	@Test
	public void functionTest() {
		String str = "      hello world";
		System.out.println(str);
		System.out.println(strHandler(str, String::trim));
	}

	//需求：用于处理字符串
	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}


	//Supplier<T> 供给型接口 :
	@Test
	public void supplierTest() {
		List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer num : list) {
			System.out.println(num);
		}
	}

	//需求：产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			list.add(sup.get());
		}
		return list;
	}

	//Consumer<T> 消费型接口
	@Test
	public void consumeTest() {
		happy(100, (m) -> System.out.println("买了把大宝剑"));
	}

	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
}
