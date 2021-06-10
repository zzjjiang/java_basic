package com.zzj.enumdemo;

/**
 * @author zouzujiang
 */
public enum FeeEnum {

    one(1, "targetName"),
    tow(2, "dueDateCount"),
    ;

    private int name;
    private String code;

    FeeEnum(int name, String code) {
        this.name = name;
        this.code = code;
    }

    public int getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(FeeEnum.one.code);
        System.out.println(FeeEnum.tow.code);
    }
}
