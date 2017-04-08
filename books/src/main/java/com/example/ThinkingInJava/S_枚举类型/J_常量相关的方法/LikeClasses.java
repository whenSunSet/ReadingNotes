package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public enum LikeClasses {
    WINKEN{
        @Override
        void behavior() {
            System.out.println("B1");
        }
    },BLINKEN{
        @Override
        void behavior() {
            System.out.println("B1");
        }
    },NOD{
        @Override
        void behavior() {
            System.out.println("B1");
        }
    };
    abstract void behavior();
}
