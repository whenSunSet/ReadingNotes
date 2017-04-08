package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;


import com.example.ThinkingInJava.U_并发.E_新类库中的构件.TaskPortion;
import com.example.ThinkingInJava.U_并发.E_新类库中的构件.WaitingTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* 在这里有100个TaskPortion任务，当一个任务完成时CountDownLatch执行countDown()是其内部计数减一。
* 而10个WaitingTask任务在执行任务时，被await()挂起，直到CountDownLatch内部计数减为0才会被唤醒。
* */
public class A_CountDownLatchDemo {
    static final int SIZE=100;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch latch=new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        executorService.shutdown();
    }
}
