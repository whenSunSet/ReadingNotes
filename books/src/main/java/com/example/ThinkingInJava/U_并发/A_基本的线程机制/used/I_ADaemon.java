package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* finally在后台线程中可能不会被调用，在前台线程中会一定被调用
* */
public class I_ADaemon implements Runnable {
    @Override
    public void run() {
        System.out.println("Start I_ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("This should always run");
        }
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new I_ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
