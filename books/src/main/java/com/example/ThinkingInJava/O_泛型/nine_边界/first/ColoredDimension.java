package com.example.ThinkingInJava.O_泛型.nine_边界.first;

import com.example.O_泛型.nine_边界.Dimension;
import com.example.O_泛型.nine_边界.HasColor;

import java.awt.Color;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){return item.getColor();}

    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}
