package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import com.example.ThinkingInJava.U_并发.A_基本的线程机制.TaskWithResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* Callable<T>可以在线程结束的时候返回一个值，该值用Future<>包装，可以通过isDone()来检查某个Callable<T>是否执行完毕。
* 如果没有执行完毕就get()，那么就会被阻塞，直至执行完毕返回get()。
* */
public class D_CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> future:futures){
            System.out.println(future.get());

        }
    }
}
