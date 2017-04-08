package com.example.ThinkingInJava.U_并发.C_终结任务;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Count {
    private int count=0;
    private Random random=new Random(47);
    public synchronized int increment(){
        int temp=count;
        if (random.nextBoolean())
            Thread.yield();
        return (count=++temp);
    }
    public synchronized int value(){return count;}
}
