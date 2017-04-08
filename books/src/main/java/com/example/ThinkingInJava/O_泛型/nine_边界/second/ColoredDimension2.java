package com.example.ThinkingInJava.O_泛型.nine_边界.second;


import com.example.ThinkingInJava.O_泛型.nine_边界.Dimension;
import com.example.ThinkingInJava.O_泛型.nine_边界.HasColor;

/**
 * Created by heshixiyang on 2017/1/16.
 */
public class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
    public ColoredDimension2(T item) {
        super(item);
    }
    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}
