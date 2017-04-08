package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.U_并发.A_基本的线程机制.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 这个是单线程的Fixed，任意时刻只有一个任务在运行
* */
public class C_SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
