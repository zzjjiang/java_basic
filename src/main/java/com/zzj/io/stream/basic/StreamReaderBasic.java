package com.zzj.io.stream.basic;

import java.io.*;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 转换流  字节流转换成字符流
 * @createTime 2020年02月14日 11:56
 */
public class StreamReaderBasic {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        InputStream is = new FileInputStream(file);
        Reader reader = new InputStreamReader(is);
        char[] chars = new char[1024];
        int len = reader.read(chars);
        System.out.println(new String(chars,0,len));
        reader.close();
        is.close();
        System.out.println(System.currentTimeMillis() - start);
    }
}
