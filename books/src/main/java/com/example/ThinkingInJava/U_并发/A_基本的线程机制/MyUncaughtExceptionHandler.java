package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(("caught " + e));
    }
}
