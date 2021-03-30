package com.zzj.test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author zouzujiang
 */
public class SuperLotto {
    public static void main(String[] args) {
        superLotto(5);
    }
    /**
     * 超级大乐透
     * @param ticketNumber 张数
     */
    public static void superLotto(int ticketNumber){
        if (ticketNumber <= 0){
            throw new IllegalArgumentException("张数不能小于1！");
        }
        for (int i = 0;i<ticketNumber;i++) {
            Set<Integer> head = new TreeSet<>();
            Set<Integer> tail = new TreeSet<>();
            while (true) {
                if (head.size() < 5) {
                    int num = (int) Math.ceil(Math.random() * 35);
                    if (!head.contains(num)) {
                        head.add(num);
                    } else {
                        continue;
                    }
                } else {
                    int num = (int) Math.ceil(Math.random() * 12);
                    if (!tail.contains(num)) {
                        tail.add(num);
                        if (tail.size() == 2) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            System.out.print(head.toString());
            System.out.println(tail.toString());
        }
    }
}
