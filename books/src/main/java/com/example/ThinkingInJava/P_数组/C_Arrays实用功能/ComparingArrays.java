package com.example.ThinkingInJava.P_数组.C_Arrays实用功能;

import java.util.Arrays;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1=new int[10];
        int[] a2=new int[10];
        Arrays.fill(a1,47);
        Arrays.fill(a2,47);
        System.out.println(Arrays.equals(a1, a2));

        a2[3]=11;
        System.out.println(Arrays.equals(a1, a2));

        String[] s1=new String[4];
        Arrays.fill(s1,"H");

        String[] s2={
            new String ("H"),
            new String ("H"),
            new String ("H"),
            new String ("H")
        };

        System.out.println(Arrays.equals(s1, s2));
    }
}
