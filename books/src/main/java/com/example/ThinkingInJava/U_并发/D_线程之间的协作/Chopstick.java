package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Chopstick {
    private boolean taken =false;
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken=true;
    }

    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}
