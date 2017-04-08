package com.example.ThinkingInJava.O_泛型.nine_边界.third;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}
