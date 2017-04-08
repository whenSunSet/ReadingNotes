package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

import java.util.concurrent.ThreadFactory;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
