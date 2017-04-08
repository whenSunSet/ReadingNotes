package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;


import com.example.ThinkingInJava.U_并发.E_新类库中的构件.CheckoutTask;
import com.example.ThinkingInJava.U_并发.E_新类库中的构件.Fat;
import com.example.ThinkingInJava.U_并发.E_新类库中的构件.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/7.
 */
public class F_SemaphoreDemo {
    final static int SIZE=25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool=new Pool<>(Fat.class,SIZE);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new CheckoutTask<>(pool));
        }
        System.out.println("All CheckoutTasks created");
        List<Fat> list=new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat fat=pool.checkOut();
            System.out.println((i + " : main() thread checked out"));
            fat.operation();
            list.add(fat);
        }
        Future<?> blocked=executorService.submit((Runnable) () -> {
            try {
                pool.checkOut();
            } catch (InterruptedException e) {
                System.out.println("checkOut() Interrupted");
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println(("Checking in objects in " + list));
        for (Fat fat:list)
            pool.checkIn(fat);
        for (Fat fat:list)
            pool.checkIn(fat);
        executorService.shutdown();
    }
}
