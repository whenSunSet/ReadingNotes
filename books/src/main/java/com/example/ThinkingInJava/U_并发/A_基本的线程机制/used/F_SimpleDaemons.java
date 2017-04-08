package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 将一个线程设置为后台线程后，后台线程不再为必要线程，当前台线程运行完毕，无论后台线程有没有运行完毕都会被杀死。
* */
public class F_SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println((Thread.currentThread() + " " + this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon=new Thread(new F_SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
