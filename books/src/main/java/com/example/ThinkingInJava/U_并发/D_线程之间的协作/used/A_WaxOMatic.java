package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;


import com.example.ThinkingInJava.U_并发.D_线程之间的协作.Car;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.WaxOff;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.WaxOn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* wait()可以将当前线程挂起：前提是要在synchronized控制的块中，因为wait需要获取需要挂起的线程所要处理对象的锁，否则会报错。
* notifyAll()和则是notify()唤醒对应锁所挂起的线程。
*
* 线程阻塞和线程挂起的区别：
* 线程阻塞：当前线程不能分到时间片，并且线程不释放对象锁。所以别的线程不能进入上锁的方法，如sleep()
* 线程挂起：当前线程不能分到时间片，并且线程释放对象锁。所以别的线程能够键入上锁的方法，效率提高了，如wait()
*
* 这里有一个要注意的问题就是：在判断是否wait()的时候需要用while(判断条件)，将其包裹起来，原因是：
* 防止当本线程被调起时，判断条件出现了不可预见的变化，从而出现错误。
*
* notifyAll使所有原来在该对象上等待被notify的线程统统退出wait的状态，变成等待该对象上的锁，一旦该对象被解锁，他们就会去竞争。
* notify则文明得多他只是选择一个wait状态线程进行通知，并使它获得该对象上的锁，但不惊动其他同样在等待被该对象notify的线程们.
* 当第一个线程运行完毕以后释放对象上的锁此时如果该对象没有再次使用notify语句，则即便该对象已经空闲.
* 其他wait状态等待的线程由于没有得到该对象的通知，继续处在wait状态，直到这个对象发出一个notify或notifyAll，它们等待的是被notify或notifyAll，而不是锁。
* */
public class A_WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car=new Car();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new WaxOff(car));
        executorService.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(500);
//        executorService.shutdownNow();
        System.exit(0);
    }
}
