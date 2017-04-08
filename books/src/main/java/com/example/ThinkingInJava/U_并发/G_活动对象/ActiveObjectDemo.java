package com.example.ThinkingInJava.U_并发.G_活动对象;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/7.
 */
/*
*活动对象工作在对象级别而不像其他设计模式工作在对象继承层级关系中。它将方法的调用和其实际的执行解耦，
*方法的执行位于对象本身的控制线程中，因而也不会阻塞调用者。总的说来，活动对象模式有6个元素：

1.代理。以公共方法的方式向客户对象提供访问接口。

2.接口。定义了活动对象上的方法请求。

3.队列。保存来自客户的挂起的请求。

4.调度器。决定从挂起的队列中选取哪个请求来执行。

5.实现。活动对象方法的实现。

6.回调/变量。客户对象用它来获取请求执行的结果，活动方法的执行结果通常被封装到成为future的对象中。
该future对象中包含了一个类似于占位符的东西。一旦活动对象完成了方法执行就会将结果放到future的占位符上。但在方法完成之前尝试获取占位符上的内容将会阻塞线程。

从活动对象的这些定义中，我们可以看出它的几个特征：

基于消息机制：对活动对象的请求和可能的参数都 被转化为消息，这些消息被转发给活动对象实际实现并排队等待处理。处理结果以future对象返还给提出请求的对象。

异步调用：对活动对象的请求被异步执行，实际由活动对象的工作线程处理请求，
故不会阻塞调用者。仅当请求未完成执行时，调用者试图获取处理结果时会被阻塞。

线程安全：活动对象天生是线程安全的。因为他顺序地从请求队列摘取消息进行处理，
并且始终在一个单独的线程中执行，由于不存在资源竞争，所以也不用担心同步、死锁等问题。同步仍旧会发生，
但它通过将方法调用排队，使得任何时刻都只能发生一个调用，从而将同步控制在消息的级别上发生。

* */
public class ActiveObjectDemo {
    private ExecutorService executorService= Executors.newSingleThreadExecutor();
    private Random random=new Random(47);
    private void pause(int factor){
        try {
            TimeUnit.MILLISECONDS.sleep(100+random.nextInt(factor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<Integer> calculateInt(final int x,final int y){
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(("starting " + x + " + " + y));
                pause(500);
                return x+y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y){
        return executorService.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println(("starting " + x + " + " + y));
                pause(500);
                return x+y;
            }
        });
    }

    public void shutdown(){
        executorService.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo activeObjectDemo=new ActiveObjectDemo();
        List<Future<?>> futures=new CopyOnWriteArrayList<>();
        for (float i = 0.0f; i < 1.0f; i+=0.2f) {
            futures.add(activeObjectDemo.calculateFloat(i,i));
        }

        for (int i = 0; i < 5; i++) {
            futures.add(activeObjectDemo.calculateInt(i,i));
        }
        System.out.println("All asynch calls made");
        while (futures.size()>0){
            for (Future<?> future:futures)
                if (future.isDone()){
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    futures.remove(future);
                }
        }
        activeObjectDemo.shutdown();
    }

}
