package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import com.example.U_并发.D_线程之间的协作.used.B_Restaurant;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class WaitPerson implements Runnable {
    private B_Restaurant restaurant;

    public WaitPerson(B_Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal==null)
                        wait();
                }
                System.out.println(("Waitperson got " + restaurant.meal));
                synchronized (restaurant.chef){
                    restaurant.meal=null;
                    restaurant.chef.notifyAll();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
