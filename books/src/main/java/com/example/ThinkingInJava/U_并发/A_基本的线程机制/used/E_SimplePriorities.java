package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 可以在run中获取当前的线程并设置线程的优先级，注意这里优先级低的线程并不会被饥饿
* yield()方法只是一种让步，调用的时候表示：本线程的工作已经做的差不多了，可以让别的同级线程进行运行了，但是并不是调用了就一定切换线程。
* */
public class E_SimplePriorities implements Runnable {
    private int countDown=5;
    private volatile double d;
    private int priority;

    public E_SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 0; i < 100000; i++) {
                d+=(Math.PI+Math.E)/(double) i;
                if (i%1000==0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown==0)return;
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread()+": "+countDown;
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            service.execute(new E_SimplePriorities(Thread.MIN_PRIORITY));
        service.execute(new E_SimplePriorities(Thread.MAX_PRIORITY));
        service.shutdown();
    }
}
