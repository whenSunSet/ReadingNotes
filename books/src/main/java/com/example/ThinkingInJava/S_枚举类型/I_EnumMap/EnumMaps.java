package com.example.ThinkingInJava.S_枚举类型.I_EnumMap;

import com.example.S_枚举类型.H_使用EnumSet代替标志.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 命令模式：只有一个单一方法的接口，然后从该接口实现具有各种各种不同行为的子类，类似于以一个方法作为参数。
* */
public class EnumMaps {
    interface Command{void action();}
    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> enumMap=new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        enumMap.put(AlarmPoints.KITCHEN, () -> System.out.println("Kitchen fire！"));
        enumMap.put(AlarmPoints.BATHROOM, () -> System.out.println("Bathroom alert！"));
        for (Map.Entry<AlarmPoints,Command> e:enumMap.entrySet()){
            System.out.println((e.getKey() + ": "));
            e.getValue().action();
        }

        try {
            enumMap.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
