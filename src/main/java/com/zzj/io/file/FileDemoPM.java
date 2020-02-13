package com.zzj.io.file;

import java.io.File;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 文件的目录创建和获取父文件
 * @createTime 2020年02月13日 22:35
 * 如何获取父路径：public File getParentFile​()；
 * 创建父目录：public boolean mkdir()、创建单级目录；
 * 创建父目录：public boolean mkdirs()、创建多级目录；
 */
public class FileDemoPM {

    public static void main(String[] args) throws Exception {
        String pathName = "/Users/zujiangzou/Desktop/demotest/towdir/tow.txt";
        File file = new File(pathName);
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            System.out.println(parentFile.getName());
            System.out.println(parentFile.getParent());
            System.out.println(parentFile.getAbsolutePath());
            boolean newFile = file.createNewFile();
            if(newFile){
                System.out.println("创建成功");
            }else {
                file.delete();
                System.out.println("创建失败");
            }
        } else {
            System.out.println("父目录不存在");
            boolean mkdir = file.mkdirs();
            if(mkdir){
                System.out.println("文件创建成功");
            }else{
                System.out.println("文件创建失败");
            }
        }
    }
}
/**
 * 文件是否可读：public boolean canRead​()；
 * 文件是否可写：public boolean canWrite​()；
 * 文件是否可执行：public boolean canExecute​()；
 * 获取文件长度(大小 uit:字节)：public long length​()、该方法返回的是long数据类型；
 * 最后一次修改日期时间：public long lastModified​()；
 * 判读是否是目录：public boolean isDirectory​()；
 * 判断是否是文件：public boolean isFile​()；
 * 文件重命名： public boolean renameTo​(File dest)；
 */
