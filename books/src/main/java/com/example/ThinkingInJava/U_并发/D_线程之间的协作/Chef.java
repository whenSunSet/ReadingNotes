package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import com.example.U_并发.D_线程之间的协作.used.B_Restaurant;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Chef implements Runnable {
    private B_Restaurant restaurant;
    private int count=0;

    public Chef(B_Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal!=null)
                        wait();
                }

                if (++count==10){
                    System.out.println("Out of food,closing");
                    restaurant.executorService.shutdownNow();
                }
                System.out.println("Order up!");
                synchronized (restaurant.waitPerson){
                    restaurant.meal=new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
