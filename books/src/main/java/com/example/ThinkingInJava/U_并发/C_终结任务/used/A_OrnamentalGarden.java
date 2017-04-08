package com.example.ThinkingInJava.U_并发.C_终结任务.used;

import com.example.U_并发.C_终结任务.Entrance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
*
* */
public class A_OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        executorService.shutdown();
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated");
        System.out.println(("Total: " + Entrance.getTotalCount()));
        System.out.println(("Sum of Entrances: " + Entrance.sumEntrances()));
    }
}
