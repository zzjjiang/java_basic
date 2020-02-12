package com.zzj.clazz;

public class InterfaceTest implements TowTest{

    @Override
    public void run() {

    }

    @Override
    public void tow() {

    }

    public static void main(String[] args) {
        InterfaceTest test = new InterfaceTest();
        System.out.println(test instanceof TowTest);
        System.out.println(test instanceof OneTest);
        ThrTest thrTest = new ThrTest();
        System.out.println(thrTest instanceof TowTest);
        System.out.println(thrTest instanceof OneTest);
    }
}
