package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;

import com.example.ThinkingInJava.U_并发.D_线程之间的协作.Receiver;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.Sender;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* Receiver和Sender两个线程，同一时刻只能有一个线程对管道进行操作，若管道中没有数据将自动阻塞，但是其不能挂起线程。
* */
public class F_PipedIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender=new Sender();
        Receiver receiver=new Receiver(sender);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        executorService.shutdownNow();
    }
}
