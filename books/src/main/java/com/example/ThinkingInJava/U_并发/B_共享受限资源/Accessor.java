package com.example.ThinkingInJava.U_并发.B_共享受限资源;

import com.example.U_并发.B_共享受限资源.used.K_ThreadLocalVariableHolder;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Accessor implements Runnable {
    private final  int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            K_ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {

        return "#"+id+": "+K_ThreadLocalVariableHolder.get();
    }
}
