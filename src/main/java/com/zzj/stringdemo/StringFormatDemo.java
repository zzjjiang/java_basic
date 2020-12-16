package com.zzj.stringdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzj
 * @description String.format
 * @date 2020.09.02
 */
public class StringFormatDemo {

    @Test
    public void testFormat(){
        int s = 1;
        System.out.println(String.format("%02d", s));
    }

    @Test
    public void testJoin(){
        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("3");
        l.add("2");
        System.out.println(String.join(",", l));
    }
}
