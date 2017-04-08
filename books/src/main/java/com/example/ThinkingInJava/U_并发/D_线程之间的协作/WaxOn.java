package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!");

                TimeUnit.SECONDS.sleep(10);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}
