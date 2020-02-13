package com.zzj.io.file;

import java.io.File;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 列出全部文件
 * @createTime 2020年02月13日 22:56
 */
public class FileDemoLf {

    public static void main(String[] args) {
        String pathName = "/Users/zujiangzou/Desktop/demotest";

        print(pathName);
    }

    private static void print(String pathName) {
        File file = new File(pathName);
        File[] files = file.listFiles();
        for (File fil:files) {
            if(fil.isDirectory()){
                System.out.println(fil);
                print(fil.getAbsolutePath());
            }else{
                System.out.println(fil);
            }
        }
    }
}
