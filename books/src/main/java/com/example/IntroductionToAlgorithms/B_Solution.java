package com.example.IntroductionToAlgorithms;

import java.util.Scanner;

/**
 * Created by heshixiyang on 2017/4/24.
 */
public class B_Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _input="1";
        while (_input.length()>0){
            _input = in.nextLine();
            System.out.println(solution(_input));
        }
    }

    /**
     给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
     输出需要删除的字符个数。

     输入描述:

     输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

     输出描述:

     对于每组数据，输出一个整数，代表最少需要删除的字符个数。

     输入例子:
     abcda
     google

     输出例子:
     2
     2
     */
    static int sI,sJ;
    public static int solution(String s){
        char[] one=s.toCharArray(),two=new char[s.length()];
        int a=s.length()-1,b=0;
        for (int i = 0; i < s.length(); i++) {
            two[i]=one[a];
            a--;
        }
        String commom=lcs(one,two);
        return s.length()-commom.length();
    }

    public static boolean isPalindrome(String one){
        char[] a=one.toCharArray();
        int j=one.length()-1;
        for (int i = 0; i < one.length(); i++) {
            if (a[i]!=a[j])return false;
            j--;
        }
        return true;
    }


    static String[][] commonSubList;
    public static String  lcs(char[] A,char[] B){
        commonSubList=new String[A.length+1][B.length+1];
        for (int i = 0; i <=A.length; i++) {
            commonSubList[i][0]="";
        }
        for (int i = 0; i <=B.length; i++) {
            commonSubList[0][i]="";
        }
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
            for (j = 0; j<B.length; j++) {
                if (A[i]==B[j]){
                    commonSubList[i+1][j+1]=commonSubList[i][j]+A[i];
                    sI=i;
                    sJ=j;
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

}
