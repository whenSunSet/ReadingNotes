package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;


import com.example.ThinkingInJava.U_并发.A_基本的线程机制.LiftOff;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.LiftOffRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* 这里分了两个线程：一个主线程，一个LiftOffRunner线程。
* 主线程是生产者负责向BlockingQueue中添加对象，LiftOffRunner线程负责消费对象。
* 我们这里没有使用任何线程加锁和同步机制，虽然有两个线程对BlockingQueue进行操作。
* 因为BlockingQueue是线程安全的容器，同一时刻只能有一个线程对其进行操作，
* 并且如果队列为空其还能自动挂起消费线程，当有对象的时候又能够自动唤醒对象。
* */
public class D_TestBlockingQueues {
    static void getKey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        LiftOffRunner runner=new LiftOffRunner(queue);
        Thread thread=new Thread(runner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press Enter msg");
        thread.interrupt();
        System.out.println("Finished msg test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",new LinkedBlockingDeque<>());
        test("ArrayBlockingQueue",new ArrayBlockingQueue<>(3));
        test("SynchronousQueue",new SynchronousQueue<>());
    }
}
