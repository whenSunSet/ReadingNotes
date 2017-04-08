package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;

import com.example.U_并发.D_线程之间的协作.Chopstick;
import com.example.U_并发.D_线程之间的协作.Philosopher;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* 死锁产生的条件：
* 1.至少有一个资源是不能被共享的
* 2.至少有一个任务持有一个资源并且在等待另一个资源
* 3.资源不能被抢占
* 4。必须有循环等待
* */
public class G_DeadlockDinningPhilosophers {
    public static void main(String[] args) throws InterruptedException, IOException {
        int ponder=0;
        if (args.length>0)
            ponder=Integer.parseInt(args[0]);
        int size=5;
        if (args.length>1)
            size=Integer.parseInt(args[1]);
        ExecutorService executorService= Executors.newCachedThreadPool();
        Chopstick[] chopsticks=new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i]=new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            executorService.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%5],i,ponder));
        }
        if (args.length==3&&args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press Enter to quit");
            System.in.read();
        }
        executorService.shutdownNow();
    }
}
