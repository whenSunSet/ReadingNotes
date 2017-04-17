package com.example.IntroductionToAlgorithms.L_动态分析;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/16.
 */
public class C_LongestCommonSubList {
    static String[][] commonSubList;
    public static void main(String[] args) throws InterruptedException {
        char[] A= Util.getRandomCharListSeedRandom(10,4);
        Thread.sleep(10);
        char[] B= Util.getRandomCharListSeedRandom(10,4);
        commonSubList=new String[A.length+1][B.length+1];
        for (int i = 0; i <=A.length; i++) {
            commonSubList[0][i]="";
        }
        for (int i = 0; i <=B.length; i++) {
            commonSubList[i][0]="";
        }
        System.out.println(lcs(A, B));
    }
     public static String  lcs(char[] A,char[] B){
         /**
          * lcs(A,B)
          * i=1
          * j=1
          * while i<=A.length
          *     while j<=B.length
          *         if A[i]==B[j]
          *             commonSubList[i][j]=commonSubList[i-1][j-1]+A[i]
          *         else
          *             if commonSubList[i][j-1].length>=commonSubList[i-1][j].length
          *                 commonSubList[i][j]=commonSubList[i][j-1]
          *             else
          *                 commonSubList[i][j]=commonSubList[i-1][j]
          *          j++
          *     i++
          * return commonSubList[i][j]
          */
         int i,j = 0;
         for (i = 0; i < A.length; i++) {
             for (j = 0; j < B.length; j++) {
                 if (A[i]==B[j]){
                     commonSubList[i+1][j+1]=commonSubList[i][j]+A[i];
                 }else {
                     if (commonSubList[i+1][j].length()>=commonSubList[i][j+1].length())
                         commonSubList[i+1][j+1]=commonSubList[i+1][j];
                     else
                         commonSubList[i+1][j+1]=commonSubList[i][j+1];
                 }
             }
         }
         return commonSubList[i][j];
     }
    static Path[] paths;

    public static class Path{
        int[] num;
        int length;

        public Path(int maxLength, int length) {
            this.length = length;
            num =new int[maxLength];
        }
    }
    public static int[] longestNumSubList(int[] A){
        /**
         * longestNumSubList(A)
         * for i=1 to A.length
         *      if path[i-1].num[path[i-1].length]<= A[i]
         *          path[i]=path[i-1] add A[i]
         *      else
         *          A[i] replace path[i-1].lastNum
         *
         */
        return null;
    }
}
