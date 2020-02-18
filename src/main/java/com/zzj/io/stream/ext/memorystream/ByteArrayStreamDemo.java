package com.zzj.io.stream.ext.memorystream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 操作终端内存
 * @author Jone
 * @version 1.0.0
 * @Description 字节内存操作流
 * @createTime 2020年02月14日 13:19
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws Exception{
        String content = "iamjone";
        //将数据保存在内存流
        InputStream bis = new ByteArrayInputStream(content.getBytes());
        //读取内存流中的数据
        OutputStream os = new ByteArrayOutputStream();
//        1.0 ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        //每次读取一个字节
        while((len = bis.read()) != -1){
            //保存到内存中
            os.write(Character.toUpperCase((char) len));
        }
        //获取内存中的全部数据和toString一样
//       1.1 byte[] bytes = bos.toByteArray();

        System.out.println(os.toString());
        os.close();
        bis.close();
    }
}
/**
 * ByteArrayInputStream构造：public ByteArrayInputStream​(byte[] buf)；
 * ByteArrayOutputStream构造：public ByteArrayOutputStream()；
 *   在ByteArrayOutputStream类中有两个很重要的方法，这两个个方法可以获取全部保存在内存流中的数据信息：
 * 获取数据：public byte[] toByteArray()；
 * 使用字符串的形式获取：public String toString()；
 */
