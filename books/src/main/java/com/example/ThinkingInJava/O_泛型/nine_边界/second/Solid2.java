package com.example.ThinkingInJava.O_泛型.nine_边界.second;


import com.example.ThinkingInJava.O_泛型.nine_边界.Dimension;
import com.example.ThinkingInJava.O_泛型.nine_边界.HasColor;
import com.example.ThinkingInJava.O_泛型.nine_边界.Weight;

/**
 * Created by heshixiyang on 2017/1/16.
 */
public class Solid2<T extends Dimension &HasColor &Weight> extends ColoredDimension2<T> {
    public Solid2(T item) {
        super(item);
    }
    int weight(){return item.weight();}
}
