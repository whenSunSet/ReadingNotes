package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread thread=Thread.currentThread();
        System.out.println(("run() by" + thread));
        System.out.println(("eh = " + thread.getUncaughtExceptionHandler()));
        throw new RuntimeException();
    }
}
