package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import com.example.ThinkingInJava.U_并发.B_共享受限资源.Accessor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 防止任务在共享资源上产生冲突的第二种办法是不共享变量，我们可以通过使用ThreadLocal<>来做到，
* 这个对象为每个线程都创建了自己的本地储存，所以本线程变量的改变不会影响其他线程变量的变化。
* 这个对象就相当于在每个线程都创建了同名的变量，但是是其内部自动创建不需要我们自己动手。Looper就是一个例子
* */
public class K_ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
        private Random random=new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };
    public static void increment(){
        value.set(value.get()+1);
    }
    public static int get(){
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Accessor(i));
        }
        TimeUnit.MICROSECONDS.sleep(1);
        executorService.shutdown();
        System.exit(0);
    }
}
