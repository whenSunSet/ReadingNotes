package com.example.IntroductionToAlgorithms.H_线性事件排序;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/9.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        int[] B=new int[10];
        countingSort(A,B,101);
        Util.printList(B);
    }

    public static void countingSort(int[] A,int[] B,int k){
        /**
         * countingSort(int[] A,int[] B,int k)
         * let C[0...k] to be a new array
         * for j=0 to k
         *      C[j]=0
         * for j=1 to A.length
         *      C[A[j]]=C[A[j]]+1
         * for i=1 to k
         *      C[i]=C[i]+C[i-1]
         *
         * for i=A.length to 1
         *      B[C[A[i]]]=A[i]
         *      C[A[i]]=C[A[i]]-1
         */

        int[] C=new int[k];
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }
        for (int i = 1; i < k; i++) {
            C[i]=C[i]+C[i-1];
        }
        for (int i = A.length-1; i >=0; i--) {
            B[C[A[i]]-1]=A[i];
            C[A[i]]--;
        }
    }
}
