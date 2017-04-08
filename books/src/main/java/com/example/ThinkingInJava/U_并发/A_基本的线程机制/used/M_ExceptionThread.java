package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 其他线程的Exception不会被扩散到main线程中，就算用来try catch也没用
* */
public class M_ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExecutorService executorService= Executors.newCachedThreadPool();
            executorService.execute(new M_ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception has been handled!");
        }
    }
}
