package com.zzj.designpattern.behavioralpattern.entrust;

/**
 * 这里用一句话描述这个类的作用
 *
 * @author jone
 * @date: 2020/01/16 15:45
 * @since JDK 1.8
 */
public class Oracle implements Company {
	@Override
	public void product() {
		System.out.println("oracle product");
	}
}
