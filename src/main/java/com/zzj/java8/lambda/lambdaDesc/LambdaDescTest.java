package com.zzj.java8.lambda.lambdaDesc;

import com.zzj.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 箭头操作符将 Lambda 表达式拆分成两部分：
 * <p>
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 * <p>
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x)
 * <p>
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * (Integer x, Integer y) -> Integer.compare(x, y);
 * <p>
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda 表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 * 可以检查是否是函数式接口
 *
 * @author Jone
 */
public class LambdaDescTest {

	@Test
	public void test() {
		//jdk 1.7 前，必须是 final
		int num = 1;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(num);
			}
		};
		r.run();
	}

	@Test
	public void comparator() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
	}


	/**
	 * 使用Comparator进行排序
	 */

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);

	@Test
	public void test1() {
		Collections.sort(emps, (e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});

		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}


}
/**
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 * <p>
 * 1. 对象的引用 :: 实例方法名
 * <p>
 * 2. 类名 :: 静态方法名
 * <p>
 * 3. 类名 :: 实例方法名
 * <p>
 * 注意：
 * ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 * <p>
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 * <p>
 * 1. 类名 :: new
 * <p>
 * 三、数组引用
 * <p>
 * 类型[] :: new;
 */