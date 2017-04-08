package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;


import com.example.ThinkingInJava.U_并发.D_线程之间的协作.Chef;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.Meal;
import com.example.ThinkingInJava.U_并发.D_线程之间的协作.WaitPerson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class B_Restaurant {
    public Meal meal;
    public ExecutorService executorService= Executors.newCachedThreadPool();
    public WaitPerson waitPerson=new WaitPerson(this);
    public Chef chef=new Chef(this);

    public B_Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }

    public static void main(String[] args) {
        new B_Restaurant();
    }
}
