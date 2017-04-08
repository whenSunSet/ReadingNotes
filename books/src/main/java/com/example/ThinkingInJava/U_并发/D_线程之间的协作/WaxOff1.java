package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class WaxOff1 implements Runnable {
    private Car1 car1;

    public WaxOff1(Car1 car1) {
        this.car1 = car1;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car1.waitForWaxing();
                System.out.println("wax Off");
                TimeUnit.MILLISECONDS.sleep(200);
                car1.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off task");
    }
}
