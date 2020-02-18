package com.zzj.io.stream.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 流 基本介绍
 * @createTime 2020年02月13日 23:43
 *
 * OutputStream  将字节数组里面的内容写到对应的文件中
 *
 * 输出单个字节数据：public abstract void write​(int b) throws IOException；
 * 输出一组字节数据：public void write​(byte[] b) throws IOException；
 * 输出部分字节数据：public void write​(byte[] b, int off, int len) throws IOException；
 *
 */
public class OutputStreamBasic {

    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
//        OutputStream outputStream = new FileOutputStream(file，true);追加
        /*OutputStream outputStream = new FileOutputStream(file);
        String content = "imjone";
        outputStream.write(content.getBytes());
        outputStream.close();*/

        try(OutputStream outputStream = new FileOutputStream(file,true)){
            String content = "\r\nimyy";
            outputStream.write(content.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


/*
所有的流操作都应采用如下统一的步骤进行，下面以文件处理的流程为例：
    如果进行文件读写操作，则一定要通过File类找到一个文件路径；
    通过字节流或字符流的子类为父类对象进行实例化；
    利用字节流或字符流中的方法实现数据的输入与输出操作；
    流的操作属于资源操作，资源操作必须进行关闭处理；
*/
