package com.example.ThinkingInJava.S_枚举类型.K_多路分发;


import com.example.ThinkingInJava.S_枚举类型.F_随机选取.Enums;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a,T b){
        System.out.println((a + " vs. " + b + ": " + a.compete(b)));
    }
    public static <T extends Enum<T>&Competitor<T>> void play(Class<T> rsbClass ,int size){
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass),Enums.random(rsbClass));
        }
    }
}
