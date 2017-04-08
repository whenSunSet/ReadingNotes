package com.example.ThinkingInJava.O_泛型.nine_边界.first;


import com.example.ThinkingInJava.O_泛型.nine_边界.Dimension;
import com.example.ThinkingInJava.O_泛型.nine_边界.HasColor;
import com.example.ThinkingInJava.O_泛型.nine_边界.Weight;

import java.awt.Color;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class Solid<T extends Dimension &HasColor &Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){return item.getColor();}

    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
    int weight(){return item.weight();}
}
