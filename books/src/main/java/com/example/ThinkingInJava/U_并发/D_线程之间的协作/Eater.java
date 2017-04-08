package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Eater implements Runnable {
    private Toast.ToastQueue finishedQueue;
    private int counter=0;

    public Eater(Toast.ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }


    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Toast toast=finishedQueue.take();
                if (toast.getId()!=counter++||toast.getStatus()!= Toast.Status.JAMMED){
                    System.out.println(("Error: " + toast));
                    System.exit(1);
                }else {
                    System.out.println(("Chomp!" + toast));
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted!");
        }
        System.out.println("Eater off");
    }
}
