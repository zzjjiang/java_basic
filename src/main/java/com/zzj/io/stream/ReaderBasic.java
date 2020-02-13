package com.zzj.io.stream;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 字符流读
 * @createTime 2020年02月14日 00:22
 */
public class ReaderBasic {
    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        Reader reader = new FileReader(file);
        char[] chars = new char[1024];
        int read = reader.read(chars);
        System.out.println(new String(chars,0,read));
    }
}
