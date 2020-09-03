package com.zzj.stringdemo;

import org.junit.Test;

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
}
