package com.zzj.test;

import org.junit.Test;

/**
 * @author zzj
 * @description
 * @date 2020.08.24
 */
public class TestDemo {

    @Test
    public void test(){
        int i = 2;
        if(i == 2){
            System.out.println("if");
        }else if(i != 0){
            System.out.println("else1");
        }else {
            System.out.println("else2");
        }
    }
}
