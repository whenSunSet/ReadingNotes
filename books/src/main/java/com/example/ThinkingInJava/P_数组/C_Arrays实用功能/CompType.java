package com.example.ThinkingInJava.P_数组.C_Arrays实用功能;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class CompType implements Comparable<CompType>{
    int i;
    int j;
    private static int count=1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result="{i ="+i+",j = "+j+"}";
        if (count++%3==0)
            result+="\n";
        return result;
    }

    @Override
    public int compareTo(CompType o) {
        return (i<o.i ? -1:(i ==o.i? 0 : 1));
    }

    private static Random random=new Random(47);

    public static void main(String[] args) {
    }
}
