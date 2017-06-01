package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class GenericCast_four {
    public static final int SIZE=10;

    public static void main(String[] args) {
        FixedSizeStack<String> stringFixedSizeStack=new FixedSizeStack<>(SIZE);
        for (String s:"A_java基础 B C_LongestCommonSubList D E F G_用函数对象表示策略 H_谨慎优化 I J".split(" "))
            stringFixedSizeStack.push(s);
        for (int i = 0; i < SIZE; i++) {
            String s=stringFixedSizeStack.pop();
            System.out.println((s + " "));
        }
    }
}
