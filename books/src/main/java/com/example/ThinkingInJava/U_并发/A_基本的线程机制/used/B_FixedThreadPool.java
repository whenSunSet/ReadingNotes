package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.ThinkingInJava.U_并发.A_基本的线程机制.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 这个种类的Executor可以固定线程池中的线程数，多余的任务就会变成一个队列当一个任务运行完了就会进行下一个任务。
* */
public class B_FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.execute(new LiftOff());
        executorService.shutdown();
    }
}
