package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 1.在这里我们可以看见自动包装机制并不能应用与数组
*
* * */
public class PrimitiveGenericTest_one {
    public static void main(String[] args) {
        String[] strings=FArray.fill(new String[7],new FArray.Generator<>("A_InsertionSort"));
        for (String s:strings)
            System.out.println(s);
        Integer[] integers=FArray.fill(new Integer[7],new FArray.Generator<>(1));
        for (int i:integers)
            System.out.println(i);
//        int[] b=FArray.fill(new int[7],new FArray.Generator<>(1));
    }
}
