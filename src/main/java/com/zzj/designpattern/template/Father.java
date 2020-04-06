package com.zzj.designpattern.template;

/**
 * 这里用一句话描述这个类的作用
 *
 * @author jone
 * @date: 2020/01/16 15:36
 * @since JDK 1.8
 */
public abstract class Father {
	public void live() {
		study();
		work();
		love();
	}

	public void study() {
		System.out.println("====要认认真真学习====");
	}

	public void work() {
		System.out.println("====主动承担责任====");
	}

	/*
	 * 该方法就是一个钩子方法，通过子类的实现干预父类的方法的业务流程
	 * 钩子方法挂载到父类方法中执行
	 * */
	//这里爸爸不强迫孩子的爱情，孩子自己实现自己的爱情
	public abstract void love();
}
