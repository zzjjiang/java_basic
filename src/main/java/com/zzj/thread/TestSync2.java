package com.zzj.thread;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/11/13 9:23
 * @since JDK 1.8
 */
public class TestSync2 implements Runnable {
	int b = 100;

	synchronized void m1() throws InterruptedException {
		System.out.println("m1");
		b = 1000;
		Thread.sleep(500);
		System.out.println("b = " + b);
	}

	synchronized void m2() throws InterruptedException {
		System.out.println("m2");
		Thread.sleep(250);
		b = 2000;
	}

	public static void main(String[] args) throws InterruptedException {
		TestSync2 tt = new TestSync2();
		//步骤一
		Thread t = new Thread(tt);
		//步骤2
		t.start();
		//步骤3
		tt.m2();
		//步骤4
		System.out.println("main thread b=" + tt.b);
	}

	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
