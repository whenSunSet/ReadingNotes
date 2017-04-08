package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;

import com.example.U_并发.D_线程之间的协作.Car1;
import com.example.U_并发.D_线程之间的协作.WaxOff1;
import com.example.U_并发.D_线程之间的协作.WaxOn1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* Condition对象可以让线程挂起或者唤醒，用的分别是这两个方法：await()和signalAll()
* Lock对象则是承担起synchronized的作用
*
* 分别对应 wait(),notifyAll,synchronized
* */
public class C_WaxOMatic1 {
    public static void main(String[] args) throws InterruptedException {
        Car1 car1=new Car1();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new WaxOff1(car1));
        executorService.execute(new WaxOn1(car1));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
