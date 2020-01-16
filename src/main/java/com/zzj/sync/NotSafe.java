package com.zzj.sync;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/12/11 17:20
 * @since JDK 1.8
 */
public class NotSafe {
	private static long count = 0;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	//count进行累加
	public void incCount() {
		count++;
	}

	//线程
	private static class Count extends Thread {

		private NotSafe simplOper;

		public Count(NotSafe simplOper) {
			this.simplOper = simplOper;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				simplOper.incCount();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		NotSafe simplOper = new NotSafe();
		//启动两个线程
		Count count1 = new Count(simplOper);
		Count count2 = new Count(simplOper);
		count1.start();
		count2.start();
		Thread.sleep(50);
		System.out.println(simplOper.count);//20000?
	}
}
