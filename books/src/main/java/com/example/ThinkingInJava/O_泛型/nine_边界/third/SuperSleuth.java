package com.example.ThinkingInJava.O_泛型.nine_边界.third;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
    public SuperSleuth(POWER power) {
        super(power);
    }
    void see(){power.seeThroughWalls();}
}
