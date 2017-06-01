package com.example.IntroductionToAlgorithms;

/**
 * Created by heshixiyang on 2017/4/25.
 */
public class E_Solution {
    public static void main(String[] args) {
        int[] A={10,22,5,75,65,80};
        int n=6;
        int[] B=new int[n];
        for (int i = 1; i < n; i++) {
            if (A[i]-A[i-1]>0)B[i]=B[i-1]+A[i]-A[i-1];
            else B[i]=B[i-1];
        }
    }

    public static int solution(int[] A,int n){
        int[] B=new int[n];
        for (int i = 1; i < n; i++) {
            if (A[i]-A[i-1]>0)B[i]=B[i-1]+A[i]-A[i-1];
            else B[i]=B[i-1];
        }


        int min=Integer.MAX_VALUE,maxC=0;
        for (int i = 0; i < n; i++) {
            if (min>A[i])min=A[i];
            if (maxC<(A[i]-min))maxC=(A[i]-min);
        }
        return maxC;
    }
}
