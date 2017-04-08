package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.U_并发.A_基本的线程机制.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 可以自定义Thread生成工厂，然后获取ExecutorService
* */
public class G_DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println((Thread.currentThread() + " " + this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new G_DaemonFromFactory());
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
