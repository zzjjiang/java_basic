package com.zzj.io.stream.basic;

import java.io.*;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 转换流-写   字节流向字符流的转换
 * @createTime 2020年02月14日 11:57
 */
public class StreamWriterBasic {
    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        OutputStream outputStream = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write("yes i do");
        //字符流有缓冲区的存在,不关闭无法写入数据。也可用flush
        writer.close();
    }
}
