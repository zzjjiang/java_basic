package com.zzj.stringdemo;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/10/23 9:39
 *
 * == 用于数值比较。 --如果是对象则比较其地址
 * 字符串常量是一个匿名对象，匿名对象一定是开辟好堆内存空间的对象。
 * equals()方法可以回避null的判断，所以要将字符串常量写在前面
 *
 * 直接赋值：只实例化一个对象，并且自动保存到对象池中，以实现该字符串实例的重用
 * 构造方法：实例化两个对象 不能自动入池，无法实现对象重用，但是可以调用intern方法入池
 *
 *
 * 对象池的目的：实现数据的共享处理；
 *
 *
 * “a”+"b"  在加载的时候变成一个
 *
 * intern()作用：1 加入常量池（运行时也可以将常量加入池中）  2返回常量池引用
 */
public class StringInternDemo {

    public static void main(String[] args) {
        //直接赋值：只实例化一个对象，并且自动保存到对象池中，以实现该字符串实例的重用
        String s1 = "zzj";
        //构造方法：实例化两个对象 不能自动入池，无法实现对象重用，使用的是其new出来的对象
        String s2 = new String("zzj");

        String s3 = "zzj";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));

        //inter加池操作
        String intern = s2.intern();
        System.out.println(s1 == intern);

        //静态
        String sj = "www.jone.com";
        String staticStr = "www." + "jone" + ".com";
        System.out.println(sj == staticStr);


        //此处有变量
        String info = "jone";
        String staticStr2 = "www." + info + ".com";
        System.out.println(sj == staticStr2);
//        String info2 = "jone";
        String runStr = "www." + info + ".com";
        //结论：运行时常量每次都不一样
        System.out.println("run--"+ staticStr2 == runStr);
    }

}
