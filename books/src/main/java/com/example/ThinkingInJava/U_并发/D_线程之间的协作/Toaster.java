package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Toaster implements Runnable {
    private Toast.ToastQueue toasts;
    private int count=0;
    private Random random=new Random(47);

    public Toaster(Toast.ToastQueue toasts) {
        this.toasts = toasts;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
                Toast toast=new Toast(count++);
                System.out.println(toast);
                toasts.put(toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
