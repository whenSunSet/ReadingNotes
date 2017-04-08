package com.example.ThinkingInJava.S_枚举类型.F_随机选取;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/1/23.
 */
public class Enums {
    private static Random random=new Random(47);
    public static <T extends Enum<T>> T random(Class<T> e){
        return random(e.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }

    enum Activity{ONE,TWO,THREE,FOUR,FIVE,SIX}

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println((Enums.random(Activity.class) + " "));
        }
    }
}
