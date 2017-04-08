package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

import java.util.concurrent.ThreadFactory;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println((this + " creating new Thread"));
        Thread thread=new Thread(r);
        System.out.println(("create " + thread));
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(("eh = " + thread.getUncaughtExceptionHandler()));
        return thread;
    }
}
