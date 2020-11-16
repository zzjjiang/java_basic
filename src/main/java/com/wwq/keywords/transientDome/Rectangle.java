package com.wwq.keywords.transientDome;

import java.io.Serializable;

public class Rectangle implements Serializable {
    private static  String className="矩形";
    private int width;
    private int heigth;
    private transient int area;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public static String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", heigth=" + heigth +
                ", area=" + area +
                '}';
    }
}
