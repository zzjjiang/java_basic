package com.wwq.lamadaTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.Callable;

/**
 * Java 8 函数式接口
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式。
 *
 * 函数式接口可以对现有的函数友好地支持 lambda。
 *
 * JDK 1.8 之前已有的函数式接口:
 * @see java.lang.Runnable
 * @see java.util.concurrent.Callable
 * @see java.security.PrivilegedAction
 * @see java.util.Comparator
 * @see java.io.FileFilter
 * @see java.nio.file.PathMatcher
 * @see java.lang.reflect.InvocationHandler
 * @see java.beans.PropertyChangeListener
 * @see java.awt.event.ActionListener
 * @see javax.swing.event.ChangeListener
 *
 * JDK 1.8 新增加的函数接口：
 * @see java.util.function
 *
 * @author william_wu
 */
public class LambdaFunctioninterfaceTest {

    /**
     * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
     * 可以检查是否是函数式接口
     */
    @Test
    public void TestFunctionInterfaceOne(){
        FunctionInterfaceOne f = (x,y) -> x*y;
        int i = f.methodOne(100, 100);
        System.out.println(i);

    }

    /**
     * 测试 java.lang.Runnable
     */
    @Test
    public void TestRunnable(){
        Runnable r = () -> {
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
        };
       Thread th = new Thread(r);
       th.start();
    }

    /**
     * 测试 java.util.concurrent.Callable
     */
    @Test
    public void TestCallable() throws Exception {
        Callable<String> c = () -> {
            String str = "TestCallable";
            return str;
        };
        String call = c.call();
        System.out.println(call);
    }
    /**
     * 测试 java.util.Comparator
     */
    @Test
    public void TestComparator(){
        Comparator<Integer> c = (x,y) -> Integer.compare(x,y);
        int compare = c.compare(10, 20);
        System.out.println(compare);
    }

}
