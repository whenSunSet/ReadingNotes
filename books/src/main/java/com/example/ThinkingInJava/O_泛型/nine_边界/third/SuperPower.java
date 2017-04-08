package com.example.ThinkingInJava.O_泛型.nine_边界.third;

/**
 * Created by heshixiyang on 2017/1/16.
 */
interface SuperPower {
}
interface XRayVision extends SuperPower{
    void seeThroughWalls();
}
interface SuperHear extends SuperPower{
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower{
    void trackBySmell();
}
