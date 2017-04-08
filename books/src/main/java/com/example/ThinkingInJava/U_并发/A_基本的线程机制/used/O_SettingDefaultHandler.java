package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.ThinkingInJava.U_并发.A_基本的线程机制.ExceptionThread2;
import com.example.ThinkingInJava.U_并发.A_基本的线程机制.MyUncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 如果要在所有Thread中使用同一个异常处理器，可以设置一个静态域，这个处理器只有在没有为某个Thread设置专门的处理器时候才会调用
* */
public class O_SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread2());
    }
}
