package com.example.ThinkingInJava.S_枚举类型.H_使用EnumSet代替标志;

import java.util.EnumSet;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* EnumSet是保持大量开关的容器，一个set是64位的long每个enum占一个bit表示其是否存在。
* 当容器里面的enum超过64个的时候，其会增加一个long，来扩展容器。
* EnumSet中必须使用同一种Enum
* */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> pointses=EnumSet.noneOf(AlarmPoints.class);
        pointses.add(AlarmPoints.BATHROOM);
        System.out.println(pointses);
        pointses.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
        System.out.println(pointses);
        pointses=EnumSet.allOf(AlarmPoints.class);
        pointses.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
        System.out.println(pointses);
        pointses.removeAll(EnumSet.of(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4));
        System.out.println(pointses);
        //将容器里面的实例排序
        pointses=EnumSet.complementOf(pointses);
        System.out.println(pointses);
    }
}
