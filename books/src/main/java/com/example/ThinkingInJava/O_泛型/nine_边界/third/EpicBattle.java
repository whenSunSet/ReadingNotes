package com.example.ThinkingInJava.O_泛型.nine_边界.third;

import java.util.List;

/**
 * Created by heshixiyang on 2017/1/16.
 */
public class EpicBattle {
    static <POWER extends SuperHear> void useSuperHearing(SuperHero<POWER> hero){
        hero.power.hearSubtleNoises();
    }

    static <POWER extends SuperHear&SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.power.hearSubtleNoises();
        hero.power.trackBySmell();
    }

    /*
    * 需要注意的是在使用通配符的时候是不支持多边界的，只能有单个边界,如下代码。
    * */
    public static void main(String[] args) {
        DogBoy boy=new DogBoy(new SuperHearSmell());
        superFind(boy);
        List<? extends SuperHear> superHears;
//        List<? extends SuperHear & SuperSmell> superHears;
    }
}
