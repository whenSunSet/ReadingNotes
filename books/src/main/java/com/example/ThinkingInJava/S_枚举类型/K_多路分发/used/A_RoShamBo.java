package com.example.ThinkingInJava.S_枚举类型.K_多路分发.used;

import com.example.ThinkingInJava.S_枚举类型.K_多路分发.Item;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 多路分发是指：在一个表达式内有多个实例，但是我们都不知道其确切类型，因此我们需要在该表达式内判断出多个类型所需要对应的具体操作。
* 一般来说有二路分发。
*
* 我们看下面就可以知道，match(newItem(),newItem())，中有两个实例，我们通过先让多态分发了第一个newItem，然后通过函数重载分发了第二个newItem。
* */
public class A_RoShamBo {
   public enum  Outcome{
        DRAW,WIN,LOSE
    }
    public static class Paper implements Item {

        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        @Override
        public Outcome eval(Scissors p) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Rock p) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Paper p) {
            return Outcome.DRAW;
        }

        @Override
        public String toString() {
            return "Paper";
        }
    }

    public static class Scissors implements Item{

        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        @Override
        public Outcome eval(Rock p) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Scissors p) {
            return Outcome.DRAW;
        }

        @Override
        public Outcome eval(Paper p) {
            return Outcome.LOSE;
        }

        @Override
        public String toString() {
            return "Scissors";
        }
    }

    public static class Rock implements Item{

        @Override
        public Outcome compete(Item it) {
            return it.eval(this);
        }

        @Override
        public Outcome eval(Paper p) {
            return Outcome.WIN;
        }

        @Override
        public Outcome eval(Scissors p) {
            return Outcome.LOSE;
        }

        @Override
        public Outcome eval(Rock p) {
            return Outcome.DRAW;
        }

        @Override
        public String toString() {
            return "Rock";
        }
    }

    static final int SIZE=20;
    private static Random random=new Random(27);
    public static Item newItem(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a,Item b){
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(),newItem());
        }
    }
}
