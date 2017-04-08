package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Horse implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private int strides=0;
    private static Random random=new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        barrier=b;
    }

    public  int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                strides+=random.nextInt(3);
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Horse "+id+" ";
    }

    public String tracks(){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }
}
