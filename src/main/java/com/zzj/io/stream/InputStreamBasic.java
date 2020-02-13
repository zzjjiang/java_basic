package com.zzj.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 输入流：读取文件中的内容到字节数组中
 * @createTime 2020年02月14日 00:05
 *
 * 读取单个字节数据：
 *   public abstract int read​() throws IOException、如果读取到底，返回-1；
 * 读取一组字节数据：
 *   public int read​(byte[] b) throws IOException、返回的读取的个数，如果读到底，返回-1；
 * 读取一组字节数据的部分内容：
 *   public int read​(byte[] b, int off, int len) throws IOException；
 */
public class InputStreamBasic {
    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        InputStream inputStream = new FileInputStream(file);

//        byte[] allBytes = inputStream.readAllBytes(); 该方法不推荐使用，一次性读取全部，文件太大会直接卡死

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        inputStream.close();
    }
}
