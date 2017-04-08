package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Car {
    private boolean waxOn=false;
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn=false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn==false){
            wait();
            System.out.println(("waxOn==false"));
        }
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn==true){
            wait();
            System.out.println(("waxOn==true"));
        }
    }

}
