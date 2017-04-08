package com.example.ThinkingInJava.U_并发.C_终结任务.used;

import com.example.U_并发.C_终结任务.IOBlocked;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 通过将IO资源关闭，我们可以实现像sleep那样。(但是对于锁，书上没讲)
* */
public class D_CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ServerSocket serverSocket=new ServerSocket(8080);
        InputStream inputStream=new Socket("localhost",8080).getInputStream();
        executorService.execute(new IOBlocked(inputStream));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(("Closing " + inputStream.getClass().getSimpleName()));
        inputStream.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(("Closing " + System.in.getClass().getSimpleName()));
        System.in.close();
    }
}
