package com.example.ThinkingInJava.S_枚举类型.C_switch语句中的enum;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 1.enum其实就是一个类，每一个定义的就是一个实例，只不过只能在enum中定义
* 2.enum可以直接用于switch语句
* */
public class TrafficLight {
    enum Signal{GREEN,YELLOW,RED}

    Signal color=Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color=Signal.GREEN;
                break;
            case GREEN:
                color=Signal.YELLOW;
                break;
            case YELLOW:
                color=Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is"+color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight=new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(trafficLight);
            trafficLight.change();
        }
    }
}
