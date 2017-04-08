package com.example.ThinkingInJava.S_枚举类型.K_多路分发;


import com.example.ThinkingInJava.S_枚举类型.K_多路分发.used.A_RoShamBo;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public interface Competitor<T extends Competitor<T>>{
    A_RoShamBo.Outcome compete(T competitor);
}