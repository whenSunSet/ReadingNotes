package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.U_并发.A_基本的线程机制.Daemon;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 由后台线程派生出来的子线程都是后台线程
* */
public class H_Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
    }
}
