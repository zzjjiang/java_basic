package com.zzj.io.stream.ext.scanner;

import java.util.Scanner;

/**
 * @author Jone
 * @version 1.0.0
 * @Description scanner类的目的解决输入流的访问问题。
 * @createTime 2020年02月14日 15:47
 *
 * 构造方法：public Scanner​(InputStream source)
 * 判断是否有数据：public boolean hasNext()
 * 取出数据：public String next()
 * 设置分隔符：public Scanner useDelimiter​(String pattern)
 */
public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
//        该方法还可以正则匹配
        if(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
