package com.example.ThinkingInJava.U_并发.C_终结任务.used;

import com.example.U_并发.C_终结任务.NIOBlocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* nio类能够自动关闭通道
* */
public class E_NIOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ServerSocket serverSocket=new ServerSocket(8080);
        InetSocketAddress inetSocketAddress=new InetSocketAddress("localhost",8080);
        SocketChannel socketChannel1=SocketChannel.open(inetSocketAddress);
        SocketChannel socketChannel2=SocketChannel.open(inetSocketAddress);
        Future<?> f=executorService.submit(new NIOBlocked(socketChannel1));
        executorService.execute(new NIOBlocked(socketChannel2));
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        socketChannel2.close();
    }
}
