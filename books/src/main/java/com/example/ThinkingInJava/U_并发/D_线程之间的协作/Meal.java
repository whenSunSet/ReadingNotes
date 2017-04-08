package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "+orderNum;
    }
}
