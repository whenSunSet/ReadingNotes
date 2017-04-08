package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法.used;

import java.util.EnumSet;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 使用这种办法比使用匿名内部类更简洁高效，EnumSet适用于大量开关。
* 对于一个参数的重复add会被忽略掉，并且其输出的次序决定于enum定义时候的次序。
* 除了abstract方法，对于一般定义的方法，其也是可以覆盖的。
* */
public class B_CarWash {
    public enum Cycle{
        UNDER_BODY{
            @Override
            void action() {
                System.out.println("Spraying the under body");
            }
        },WHEEL_WASH{
            @Override
            void action() {
                System.out.println("washing the under wheels");
            }
        },PRE_WASH{
            @Override
            void action() {
                System.out.println("Loosening the under dirt");
            }
        },BASIC{
            @Override
            void action() {
                System.out.println("the basic wash");
            }
        },HOT_WAX{
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },RINSE{
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },BLOW_DRY{
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }
    EnumSet<Cycle> cycles=EnumSet.of(Cycle.BASIC,Cycle.RINSE);

    public void add(Cycle cycle){cycles.add(cycle);}
    public void washCar(){
        for (Cycle cycle:cycles)
            cycle.action();
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        B_CarWash wash=new B_CarWash();
        System.out.println(wash);
        wash.washCar();
        wash.add(Cycle.BLOW_DRY);
        wash.add(Cycle.BLOW_DRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOT_WAX);
        System.out.println(wash);
        wash.washCar();
    }
}
