package com.example.ThinkingInJava.O_泛型.nine_边界.second;

import com.example.O_泛型.nine_边界.HasColor;

import java.awt.Color;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class Colored2<T extends HasColor> extends HoldItem<T>{
    public Colored2(T item) {
        super(item);
    }
    Color color(){return item.getColor();}
}
