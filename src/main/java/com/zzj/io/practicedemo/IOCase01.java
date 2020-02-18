package com.zzj.io.practicedemo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 编写程序，输入3个整数并求出最大值和最小值（输入错误可以冲重新输入）
 * @createTime 2020年02月14日 17:05
 */
public class IOCase01 {

    public static void main(String[] args) {
        int[] ints = new int[3];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = getValue();
        }
        Arrays.sort(ints);
        System.out.println("最大值为：" + ints[ints.length - 1] + "---" + "最小值为：" + ints[0]);
    }

    private static int getValue() {
        Scanner sc = null;
        int i = 0;
        while (i < 3) {
            System.out.println("请输入数字：");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                return  sc.nextInt();
            } else {
                i++;
                System.out.println("输入内容不正确!!!");
            }
        }
        throw new IllegalArgumentException();

    }
}
