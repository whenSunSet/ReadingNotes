package com.example.ThinkingInJava.O_泛型.nine_边界.first;


import com.example.O_泛型.nine_边界.Bounded;

/**
 * Created by heshixiyang on 2017/1/16.
 */
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid=new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }

//    HasColor和Weight提供方法，Dimension提供属性，Bouned就是一个具体的边界。
//    Colored、ColoredDimension和Solid是递进的关系，其中分别需要存储HasColor、（HasColor和Dimension）、(HasColor、Dimension和Weight)。
//    这里有个不足就是Colored、ColoredDimension和Solid并不是继承关系，导致许多代码冗余。
}
