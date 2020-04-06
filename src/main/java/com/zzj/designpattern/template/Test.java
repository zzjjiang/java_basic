package com.zzj.designpattern.template;

/**
 * 模板设计模式
 *
 * @author jone
 * @date: 2020/01/16 15:37
 * @since JDK 1.8
 */
public class Test {
	public static void main(String[] args) {
		Father father = new LiSon();
		father.live();
	}
}
