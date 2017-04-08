package com.example.ThinkingInJava.S_枚举类型.K_多路分发;


import com.example.ThinkingInJava.S_枚举类型.K_多路分发.used.A_RoShamBo;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public interface Item {
    A_RoShamBo.Outcome compete(Item it);
    A_RoShamBo.Outcome eval(A_RoShamBo.Paper p);
    A_RoShamBo.Outcome eval(A_RoShamBo.Scissors p);
    A_RoShamBo.Outcome eval(A_RoShamBo.Rock p);
}
