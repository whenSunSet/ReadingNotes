package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random=new Random(47);
    private void pause() throws InterruptedException {
        if (ponderFactor==0)return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public String toString() {
        return "Philosopher "+id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println((this + " " + "thinking"));
                pause();
                System.out.println((this + " " + "grabbing right"));
                right.take();
                System.out.println((this + " " + "grabbing left"));
                left.take();
                System.out.println((this + " " + "eating"));
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println((this + " " + "exiting via interrupt"));
        }

    }
}
