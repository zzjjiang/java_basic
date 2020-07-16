package com.zzj.io.stream.basic;

import java.io.*;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 用字符流写图片，看是否可行  结论：字符流无法操作图片
 * @createTime 2020年02月14日 12:25
 */
public class UseWriterDemo {

    public static void main(String[] args) throws Exception{
        String pathName = "/Users/zujiangzou/Desktop/WechatIMG11.jpeg";
        String path2Name = "/Users/zujiangzou/Desktop/WechatIMG12.jpeg";
        File file = new File(pathName);
        File file2 = new File(path2Name);

       /* Reader reader = new FileReader(file);
        Writer writer = new FileWriter(file2);
        char[] chars = new char[1024];
        int len = 0;
        while((len = reader.read()) != -1){
            writer.write(chars,0, len);
        }
        writer.flush();
        writer.close();
        reader.close();*/

       InputStream is = new FileInputStream(file);
       OutputStream os = new FileOutputStream(file2);
       /*byte[] bytes = new byte[1024];
        int len;
        while((len = is.read(bytes)) != -1){
            os.write(bytes,0,len);
        }*/



//       2020 7 13 注以下两行
//        long l = is.transferTo(os);
//        System.out.println(l);
        os.close();
        is.close();
    }
}
