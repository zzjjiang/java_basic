package com.wwq.keywords.transientDome;

import java.io.*;

/**
 * 变量修饰符，用transient关键字标记的成员变量不参与序列化过程。
 */
public class TransientTest {

    public static final String RECTANGLE_FILE = "rectangleFile";

    public static void main(String[] args) throws Exception {
        // 初始化对象
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(2);
        rectangle.setHeigth(4);
        rectangle.setArea(8);
        System.out.println(rectangle);// Rectangle{width=2, heigth=4, area=8}
        // 将对象序列化到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RECTANGLE_FILE));
        oos.writeObject(rectangle);
        oos.close();
        // 从文件中读取对象
        File file= new File(RECTANGLE_FILE);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Rectangle newRectangle = (Rectangle)ois.readObject();
        System.out.println(newRectangle);// Rectangle{width=2, heigth=4, area=0}
    }

}
