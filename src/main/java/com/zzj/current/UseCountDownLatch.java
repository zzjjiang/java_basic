package com.zzj.current;

import com.zzj.utils.StringUtils;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {

	static CountDownLatch latch = new CountDownLatch(300);

	/**
	 * 初始化线程
	 */
	private static class InitThread implements Runnable {

		@Override
		public void run() {
			System.out.println(StringUtils.getUUID());
			latch.countDown();
		}
	}


	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= 300; i++) {
			Thread thread = new Thread(new InitThread());
			thread.start();
		}

		latch.await();
		System.out.println("Main do ites work........");
	}
}
