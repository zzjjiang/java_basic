package com.zzj.designPattern.entrust;

/**
 * 委托设计模式
 *
 * @author jone
 * @date: 2020/01/16 15:45
 * @since JDK 1.8
 */
public class Boss implements Company {
	Sun sun = new Sun();

	@Override
	public void product() {
		sun.product();
	}
}
