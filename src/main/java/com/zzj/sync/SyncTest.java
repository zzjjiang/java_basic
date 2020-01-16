package com.zzj.sync;

/**
 * @author jone
 * @version 1.0
 * @date: 2019/12/9 18:27
 * @since JDK 1.8
 */
public class SyncTest {

	private int count = 0;

	public synchronized void add() {
		count++;
	}

	public void add1() {
		synchronized (this) {
			count++;
		}
	}

	public final void add2() {
		count++;
	}

	public static void main(String[] args) {
		SyncTest syncTest = new SyncTest();
		syncTest.add();
		System.out.println(syncTest.count);
	}
}
