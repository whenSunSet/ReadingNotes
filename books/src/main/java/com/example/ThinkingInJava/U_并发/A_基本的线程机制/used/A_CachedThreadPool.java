package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.U_并发.A_基本的线程机制.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* shutdown()可以防止之后再有新的任务被提交到ExecutorService中
* */
public class A_CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            executorService.execute(new LiftOff());
        executorService.shutdown();
    }
}
