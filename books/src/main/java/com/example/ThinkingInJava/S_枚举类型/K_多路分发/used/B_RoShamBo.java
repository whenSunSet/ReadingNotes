package com.example.ThinkingInJava.S_枚举类型.K_多路分发.used;

import com.example.S_枚举类型.K_多路分发.Competitor;
import com.example.S_枚举类型.K_多路分发.RoShamBo;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 使用enum的两路分发，第一次是使用构造函数分发，第二次是使用switch分发，简单了很多。
* */
public enum B_RoShamBo implements Competitor<B_RoShamBo> {

    PAPER(A_RoShamBo.Outcome.DRAW, A_RoShamBo.Outcome.LOSE, A_RoShamBo.Outcome.WIN),
    SCISSORS(A_RoShamBo.Outcome.WIN, A_RoShamBo.Outcome.DRAW, A_RoShamBo.Outcome.LOSE),
    ROCK(A_RoShamBo.Outcome.LOSE, A_RoShamBo.Outcome.WIN, A_RoShamBo.Outcome.DRAW);

    private A_RoShamBo.Outcome vPAPER,vSCISSORS,vROCK;

    B_RoShamBo(A_RoShamBo.Outcome vPAPER, A_RoShamBo.Outcome vSCISSORS, A_RoShamBo.Outcome vROCK) {
        this.vPAPER = vPAPER;
        this.vSCISSORS = vSCISSORS;
        this.vROCK = vROCK;
    }

    public A_RoShamBo.Outcome compete(B_RoShamBo i){
        switch (i){
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(B_RoShamBo.class,20);
    }
}
