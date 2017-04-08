package com.example.ThinkingInJava.O_泛型.nine_边界;

import java.awt.Color;

/**
 * Created by heshixiyang on 2017/1/16.
 */
public class Bounded extends Dimension implements HasColor,Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }

}
