package com.example.ThinkingInJava.S_枚举类型.E_实现而非继承;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 由于Enum的子类已经继承了Enum类，所以其只能实现接口
* */
public class EnumImplementation {
    interface  A<T>{
        public T next();
    }
    enum CartoonCharacter implements A<CartoonCharacter> {
        SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
        private Random random=new Random(47);
        @Override
        public CartoonCharacter next() {
            return values()[random.nextInt(values().length)];
        }
    }

    public static <T> void printNext(A<T> r){
        System.out.println((r.next() + ", "));
    }

    public static void main(String[] args) {
        CartoonCharacter cartoonCharacter=CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cartoonCharacter);
        }
    }
}
