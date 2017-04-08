package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Jammer implements Runnable {
    private Toast.ToastQueue butteredQueue,finishedQueue;

    public Jammer(Toast.ToastQueue butteredQueue, Toast.ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast= null;
                toast = butteredQueue.take();

                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }

        System.out.println("Jammer of");
    }
}
