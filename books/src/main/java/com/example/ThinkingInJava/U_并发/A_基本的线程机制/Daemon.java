package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

/**
 * Created by heshixiyang on 2017/2/4.
 */

public class Daemon implements Runnable {
    private Thread[] threads=new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println(("DaemonSpawn " + i + " started. "));
        }
        for (int i = 0; i < threads.length; i++) {
            System.out.println(("threads[" + i + "].isDaemon() =" + threads[i].isDaemon() + ", "));
        }
        while (true)
            Thread.yield();
    }

    public static class DaemonSpawn implements Runnable{

        @Override
        public void run() {
            while (true)
                Thread.yield();
        }
    }
}
