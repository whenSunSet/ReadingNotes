package com.example.ThinkingInJava.U_并发.C_终结任务;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class NIOBlocked implements Runnable {
    private final SocketChannel socketChannel;

    public NIOBlocked(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println(("waiting for read() in " + this));
            socketChannel.read(ByteBuffer.allocate(1));
        } catch (IOException e) {
            System.out.println("exception");
        }
        System.out.println(("Exiting NIOBlocked.run() " + this));
    }
}
