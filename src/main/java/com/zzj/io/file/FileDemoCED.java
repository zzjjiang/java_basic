package com.zzj.io.file;

import java.io.File;

/**
 *
 * 在java.io包中File类是唯一一个与文件本身有关的程序处理类，
 * 但是File只能操作文件本身，却不能操作文件内容。在实际的开发中，
 * IO操作的核心意义在于：输入与输出操作。而对于程序，输入和输出可能来自于不同的环境
 * @author Jone
 * @version 1.0.0
 * @Description file类的新建  是否存在 删除
 * @createTime 2020年02月13日 22:11
 * 创建新文件：public boolean createNewFile​() throws IOException；
 * 判断文件是否已存在：public boolean exists​()；
 * 删除文件：public boolean delete​()；
 *
 * windows的路径分隔符“\”，linux的路径分隔符“/”
 *   public static final String separator；
 */
public class FileDemoCED {

    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        if(file.exists()){
            boolean delete = file.delete();
            if (delete) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }else {
            boolean newFile = file.createNewFile();
            if(newFile){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }
    }
}
