package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;

import com.example.U_并发.E_新类库中的构件.DelayedTask;
import com.example.U_并发.E_新类库中的构件.DelayedTaskConsumer;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* DelayQueue里面放的是实现了Delayed的接口，Delayed接口需要实现两个方法：
* getDelay(TimeUnit unit)是为了返回该任务锁需延长的时间
* compareTo(Delayed o)是为了比较到底那个任务需要排在前面
* 当使用queue.take()的时候延时开始，此时本线程挂起，直到延时结束开始运行run()中的任务。
* */
public class C_DelayQueueDemo {
    public static void main(String[] args) {
        Random random=new Random(47);
        ExecutorService executorService= Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue=new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(random.nextInt(500000)));
        }
        queue.add(new DelayedTask.EndSentinel(500000,executorService));
        executorService.execute(new DelayedTaskConsumer(queue));
        System.out.println("ss");
        System.out.println("ss");
        System.out.println("ss");
        System.out.println("ss");
    }
}
