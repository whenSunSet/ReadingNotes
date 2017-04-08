package com.example.ThinkingInJava.P_数组.A_多维数组;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 多维数组的创建
* */
public class A_Create {
    public static void main(String[] args) {
        int[][] a={
                {1,2,3},
                {4,5,6}
        };
        Arrays.deepToString(a);

        int[][][] b=new int[1][2][3];
        Arrays.deepToString(b);

        /*
        * 1.对于n多维数组，只要初始化最外层的一个n-1维数组就行了，其内层在用的时候再初始化也行。
        * 2.每个同级数组的长度可以不同：粗糙数组
        * */
        Random random=new Random(47);
        int[][][] c=new int[random.nextInt(5)][][];
        for (int i = 0; i < c.length; i++) {
            c[i]=new int[random.nextInt(5)][];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j]=new int[random.nextInt(5)];
            }
        }

        /*
        * 自动包装对数组初始化也有用
        * */
        Integer[][] d={
                {1,2,3},
                {4,5,6,7}
        };

        /*
        * 练习5
        * */
        int[][][] e=new int[2][][];
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }
}
