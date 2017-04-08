package com.example.ThinkingInJava.P_数组.C_Arrays实用功能;

import java.util.Arrays;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 1.这个函数对所有类都做了重载
* 2.基本类型和对象都能进行复制
* 3.如果复制对象数组，只是复制了对象的引用
* 4.不会自动包装和自动拆包
* */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i=new int[7];
        int[] j=new int[7];
        Arrays.fill(i,47);
        Arrays.fill(j,99);

        System.out.println(("i =" + Arrays.toString(i)));
        System.out.println(("j =" + Arrays.toString(j)));

        System.arraycopy(i,0,j,0,i.length);
        System.out.println(("j =" + Arrays.toString(j)));

        int[] k=new int[50];
        Arrays.fill(k,103);
        System.arraycopy(i,0,k,0,i.length);
        System.out.println(("l =" + Arrays.toString(k)));

        Integer[] integers=new Integer[10];
        Arrays.fill(integers,10);
        System.out.println(("integers =" + Arrays.toString(integers)));

//        System.arraycopy(i,0,integers,0,i.length);
        System.out.println(("integers =" + Arrays.toString(integers)));

    }
}
