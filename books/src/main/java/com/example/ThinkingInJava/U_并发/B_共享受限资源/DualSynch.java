package com.example.ThinkingInJava.U_并发.B_共享受限资源;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class DualSynch {
    private Object synchObject=new Object();
    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (synchObject){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
