package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;


import com.example.ThinkingInJava.U_并发.A_基本的线程机制.ExceptionThread2;
import com.example.ThinkingInJava.U_并发.A_基本的线程机制.HandlerThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 我们可以Thread工厂中为Thread添加一个异常处理类
* */
public class N_CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread2());
    }
}
