package com.zzj.io.practicedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 用键盘输入文件的内容和要保存的文件名称，然后根据输入的名称创建文件，并将内容保存得到文件中。
 * @createTime 2020年02月14日 17:24
 */
public class IOCase02 {

    private static final String PATH_NAME = "/Users/zujiangzou/Desktop/demotest/";

    public static void main(String[] args) {
        try {
            System.out.println("请输入文件名称：");
            String fileName = getStr();
            System.out.println("请输入文件内容：");
            String content = getStr();
            boolean save = false;
            save = save(fileName, content);
            System.out.println(save ? "成功" : "失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean save(String fileName, String content) throws Exception {
        File file = new File(PATH_NAME + fileName);
        OutputStream os = new FileOutputStream(file);
        os.write(content.getBytes());
        os.close();
        return true;
    }

    private static String getStr() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            return sc.next();
        }else{
            throw new RuntimeException("无内容");

        }
    }
}
