package com.example.ThinkingInJava.U_并发.C_终结任务;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Entrance implements Runnable {
    private static Count count=new Count();
    private static List<Entrance> entrances=new ArrayList<>();
    private int number=0;
    private final int id;
    private static volatile boolean canceled=false;
    public static void cancel(){
        canceled=true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled){
            ++number;

            System.out.println((this + " Total: " + count.increment()));

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println(("Stopping " + this));
    }

    public int getValue(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance "+id+": "+getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum=0;
        for (Entrance entrance:entrances)
            sum+=entrance.getValue();
        return sum;
    }
}
