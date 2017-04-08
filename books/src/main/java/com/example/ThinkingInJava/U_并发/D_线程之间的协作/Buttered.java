package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Buttered implements Runnable {
    private Toast.ToastQueue dryQueue,butteredQueue;

    public Buttered(Toast.ToastQueue dryQueue, Toast.ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast=dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }

        } catch (InterruptedException e) {
            System.out.println("Butter off");
        }
        System.out.println("Buttered of");
    }
}
