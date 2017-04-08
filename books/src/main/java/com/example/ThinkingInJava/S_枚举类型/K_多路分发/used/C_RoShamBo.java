package com.example.ThinkingInJava.S_枚举类型.K_多路分发.used;

import com.example.S_枚举类型.K_多路分发.Competitor;
import com.example.S_枚举类型.K_多路分发.RoShamBo;

import java.util.EnumMap;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* EnumMap性能很好，所以我们可以使用它来进行两路分发
* 在compete(C_RoShamBo competitor)中我们用链式结构在一行语句中实现了两次分发
* */
public enum C_RoShamBo implements Competitor<C_RoShamBo> {
    PAPER,SCISSORS,ROCK;
    static EnumMap<C_RoShamBo,EnumMap<C_RoShamBo,A_RoShamBo.Outcome>> table=new EnumMap<>(C_RoShamBo.class);
    static {
        for (C_RoShamBo CRoShamBo_ : C_RoShamBo.values())
            table.put(CRoShamBo_,new EnumMap<>(C_RoShamBo.class));
        initRow(PAPER, A_RoShamBo.Outcome.DRAW, A_RoShamBo.Outcome.LOSE, A_RoShamBo.Outcome.WIN);
        initRow(SCISSORS, A_RoShamBo.Outcome.WIN, A_RoShamBo.Outcome.DRAW, A_RoShamBo.Outcome.LOSE);
        initRow(ROCK, A_RoShamBo.Outcome.LOSE, A_RoShamBo.Outcome.WIN, A_RoShamBo.Outcome.DRAW);
    }
    static void initRow(C_RoShamBo CRoShamBo_, A_RoShamBo.Outcome vPAPER, A_RoShamBo.Outcome vSCISSORS, A_RoShamBo.Outcome vROCK){
        EnumMap<C_RoShamBo,A_RoShamBo.Outcome> roShamBo_5OutcomeEnumMap= C_RoShamBo.table.get(CRoShamBo_);
        roShamBo_5OutcomeEnumMap.put(C_RoShamBo.PAPER,vPAPER);
        roShamBo_5OutcomeEnumMap.put(C_RoShamBo.SCISSORS,vSCISSORS);
        roShamBo_5OutcomeEnumMap.put(C_RoShamBo.ROCK,vROCK);
    }
    @Override
    public A_RoShamBo.Outcome compete(C_RoShamBo competitor) {
        return table.get(this).get(competitor);
    }

    public static void main(String[] args) {
        RoShamBo.play(C_RoShamBo.class,20);
    }
}
