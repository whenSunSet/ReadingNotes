package com.example.ThinkingInJava.O_泛型.nine_边界.first;

import com.example.ThinkingInJava.O_泛型.nine_边界.HasColor;

import java.awt.Color;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class Colored<T extends HasColor> {
    T item;

    public Colored(T item) {
        this.item = item;
    }

    T getItem(){return item;}

    Color color(){return item.getColor();}
}
