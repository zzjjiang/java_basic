package com.wwq.keywords.volatileDome;

/**
 * java 关键字 之 volatile
 * Java语言提供了一种稍弱的同步机制，即volatile变量，用来确保将变量的更新操作通知到其他线程
 */
public class VolatileTest {
    public static  boolean isReader = false;
    public static  int readInt = 0;
//    public static volatile boolean isReader = false;
//    public static volatile int readInt = 0;
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        // 主线程稍等下 才能看到效果
        Thread.sleep(10);
        isReader = true;
        readInt = 20;

    }

    static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (true){
                int a = readInt;
                if (isReader) {
                    System.out.println(a);
                    break;
                }
            }
        }
    }
}
