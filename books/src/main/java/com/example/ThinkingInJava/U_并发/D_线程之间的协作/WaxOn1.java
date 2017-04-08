package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class WaxOn1 implements Runnable {
    private Car1 car1;

    public WaxOn1(Car1 car) {
        this.car1 = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);

                car1.waxed();
                car1.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax On task");
    }
}
