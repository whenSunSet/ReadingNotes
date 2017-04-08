package com.example.ThinkingInJava.O_泛型.nine_边界.third;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class CanineHero <POWER extends SuperHear&SuperSmell> extends SuperHero<POWER>{
    public CanineHero(POWER power) {
        super(power);
    }
    void  hear(){power.hearSubtleNoises();}
    void smell(){power.trackBySmell();}
}
