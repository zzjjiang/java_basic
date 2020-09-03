package com.zzj.exception;

import org.junit.Test;

/**
 * @author zzj
 * @description
 * @date 2020.07.22
 */
public class FirstException {

    @Test
    public void test(){
        myMethod();
        System.out.println("this is test");
    }

    public void myMethod(){
        try{
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("this is my method");
    }


}
