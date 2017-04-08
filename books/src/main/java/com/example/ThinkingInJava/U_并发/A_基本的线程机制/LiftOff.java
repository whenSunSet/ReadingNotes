package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class LiftOff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final  int id=taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+").";
    }

    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
