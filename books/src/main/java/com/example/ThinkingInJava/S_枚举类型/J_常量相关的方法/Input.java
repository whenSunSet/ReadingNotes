package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        @Override
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{
        @Override
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    public int amount(){return value;}
    static Random random=new Random(47);
    public static Input randomeSelection(){
        return values()[random.nextInt(values().length-1)];
    }
}
