package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;


import com.example.ThinkingInJava.U_并发.E_新类库中的构件.PrioritizedTaskConsumer;
import com.example.ThinkingInJava.U_并发.E_新类库中的构件.PrioritizedTaskProducer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by heshixiyang on 2017/2/7.
 */
/*
* 在这里PrioritizedTaskConsumer和PrioritizedTaskProducer两个线程同时对PriorityBlockingQueue线程进行处理，
* PrioritizedTaskProducer为优先队列新增任务并设置其优先值。
* PrioritizedTaskConsumer消耗任务，消耗任务顺序是根据优先值来。
* PriorityBlockingQueue能够根据Comparable<>接口进行排序。
* PriorityBlockingQueue内部有其自己的同步机制，所以不需要显式同步，同时如果队列中没有元素，读取者线程会被阻塞。
* 疑问：有多个读取者的时候，是否都被阻塞。
* */
public class D_PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random random=new Random(47);
        ExecutorService executorService= Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue=new PriorityBlockingQueue<>();
        executorService.execute(new PrioritizedTaskProducer(queue,executorService));
        executorService.execute(new PrioritizedTaskConsumer(queue));
    }
}
