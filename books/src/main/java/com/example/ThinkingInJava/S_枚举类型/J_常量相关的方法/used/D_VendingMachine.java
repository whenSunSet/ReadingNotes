package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法.used;

import com.example.O_泛型.eleven_问题.FArray;
import com.example.S_枚举类型.J_常量相关的方法.Category;
import com.example.S_枚举类型.J_常量相关的方法.Input;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* enum可以很方便的实现状态机
* */
public class D_VendingMachine {
    private static State state=State.RESTING;
    private static int amount=0;
    private static Input selection=null;
    enum StateDuration{TRANSIENT}
    enum State{
        RESTING{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount+=input.amount();
                        state=ADDING_MONEY ;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                    default:
                }
            }
        },ADDING_MONEY{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount+=input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection=input;
                        if (amount<selection.amount())
                            System.out.println(("Insufficient money for " + selection));
                        else
                        state= DISCARDING;
                        break;
                    case QUIT_TRANSACTION:
                        state=GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state=TERMINAL;
                    default:
                }
            }
        },DISCARDING(StateDuration.TRANSIENT){
            @Override
            void next(Input input) {
                System.out.println(("here is your " + selection));
                amount-=selection.amount();
                state=GIVING_CHANGE;
            }
        },GIVING_CHANGE(StateDuration.TRANSIENT){
            @Override
            void next(Input input) {
                if (amount>0){
                    System.out.println(("Your change: " + amount));
                    amount=0;
                }
                state=RESTING;
            }
        },TERMINAL{
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient =false;
        State(){}
        State(StateDuration trans){
            isTransient=true;
        }
        void next(Input input){
            throw new RuntimeException("Only call next(Input input)  for non-transient states");
        }
        void next(){
            throw new RuntimeException("Only call next() for "+"StateDuration.TRANSIENT states");
        }
        void output(){
            System.out.println(amount);
        }
    }

    static void run(FArray.Generator<Input> generator){
        while (state!=State.TERMINAL){
            state.next(generator.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
//        run(new FArray.Generator<>());
    }
}
