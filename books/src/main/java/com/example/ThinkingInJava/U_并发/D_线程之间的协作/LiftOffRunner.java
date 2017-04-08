package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import com.example.U_并发.A_基本的线程机制.LiftOff;

import java.util.concurrent.BlockingQueue;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff liftOff){
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff l=rockets.take();
                l.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
