package com.zzj.java8.stream;

import com.alibaba.fastjson.JSON;
import com.zzj.java8.pojo.Trader;
import com.zzj.java8.pojo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 这里用一句话描述这个类的作用
 *
 * @author jone
 * @date: 2020/01/19 15:44
 * @since JDK 1.8
 */
public class TestStreamAPITest {
	List<Transaction> transactions = null;

	@Before
	public void before() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}

	@Test
	public void test111() {
		Map<Integer, List<Transaction>> collect =
				transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
		System.out.println(JSON.toJSONString(collect));
	}


	//1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
	@Test
	public void test1() {
		transactions.stream()
				.filter((t) -> t.getYear() == 2011)
				.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
				.forEach(System.out::println);
	}

	//2. 交易员都在哪些不同的城市工作过？
	@Test
	public void test2() {
		transactions.stream()
				.map((t) -> t.getTrader().getCity())
				.distinct()
				.forEach(System.out::println);
	}

	//3. 查找所有来自剑桥的交易员，并按姓名排序
	@Test
	public void test3() {
		transactions.stream()
				.filter((t) -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getTrader)
				.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
				.distinct()
				.forEach(System.out::println);
	}

	//4. 返回所有交易员的姓名字符串，按字母顺序排序
	@Test
	public void test4() {
		transactions.stream()
				.map((t) -> t.getTrader().getName())
				.sorted()
				.forEach(System.out::println);

		System.out.println("-----------------------------------");

		String str = transactions.stream()
				.map((t) -> t.getTrader().getName())
				.sorted()
				.reduce("", String::concat);

		System.out.println(str);

		System.out.println("------------------------------------");

		transactions.stream()
				.map((t) -> t.getTrader().getName())
				.flatMap(TestStreamAPITest::filterCharacter)
				.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
				.forEach(System.out::print);
	}

	public static Stream<String> filterCharacter(String str) {
		List<String> list = new ArrayList<>();

		for (Character ch : str.toCharArray()) {
			list.add(ch.toString());
		}

		return list.stream();
	}

	//5. 有没有交易员是在米兰工作的？
	@Test
	public void test5() {
		boolean bl = transactions.stream()
				.anyMatch((t) -> t.getTrader().getCity().equals("Milan"));

		System.out.println(bl);
	}


	//6. 打印生活在剑桥的交易员的所有交易额
	@Test
	public void test6() {
		Optional<Integer> sum = transactions.stream()
				.filter((e) -> e.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.reduce(Integer::sum);

		System.out.println(sum.get());
	}


	//7. 所有交易中，最高的交易额是多少
	@Test
	public void test7() {
		Optional<Integer> max = transactions.stream()
				.map((t) -> t.getValue())
				.max(Integer::compare);

		System.out.println(max.get());
	}

	//8. 找到交易额最小的交易
	@Test
	public void test8() {
		Optional<Transaction> op = transactions.stream()
				.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));

		System.out.println(op.get());
	}


	@Test
	public void flatMapTest() {
		List<String> list = Arrays.asList("hello", "world");
		List<String> collect = list.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		System.out.println(JSON.toJSONString(collect));
	}
}
