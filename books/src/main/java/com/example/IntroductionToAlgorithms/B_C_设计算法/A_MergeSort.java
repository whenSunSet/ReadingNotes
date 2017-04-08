package com.example.IntroductionToAlgorithms.B_C_设计算法;


/**
 * Created by heshixiyang on 2017/2/10.
 */

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * 归并排序：用了分治思想(分解总问题成为子问题--》解决子问题--》合并子问题从而解决总问题)
 * n*lgn
 */
public class A_MergeSort {
    public static void main(String[] args) {
        int[] ints= Util.getRandomIntListHasBounder(6,100);

        mergeSort(ints,0,ints.length-1);
        Util.printList(ints);
    }

    public static void mergeSort(int[] ints,int start,int end){
        if (start<end){
            int middle=(start+end)/2;
            mergeSort(ints,start,middle);
            mergeSort(ints,middle+1,end);
            merge(ints,start,middle,end);
        }
    }

    public static void merge(int[] ints,int start,int middle,int end){

        /**
         * merge(A,start,middle,end)
         * n1=middle-start+1
         * n2=end-middle
         * let L[1..n1+1] and R[1..n2+1] to be array
         * for j=1 to n1
         *      L[j]=A[start+j-1]
         * for j=1 to n2
         *      R[j]=A[middle+j]
         * L[n1+1]=MAX
         * R[n2+1]=MAX
         * l=1;
         * r=1;
         * for j=start to end
         *      if L[l]>=R[r]
         *          A[j]=R[r]
         *          r++
         *      else
         *          A[j]=L[l]
         *          l++
         */

        int lengthLeft=middle-start+1;
        int lengthRight=end-middle;

        int[] leftList=new int[lengthLeft+1];
        int[] rightList=new int[lengthRight+1];

        for (int i = 0; i < lengthLeft; i++) {
            leftList[i]=ints[start+i];
        }

        for (int i = 0; i <lengthRight; i++) {
            rightList[i]=ints[middle+1+i];
        }

        leftList[lengthLeft]=Util.MAX;
        rightList[lengthRight]=Util.MAX;

        int l=0,r=0;
        for (int i = start; i <=end ; i++) {
            if (leftList[l]>=rightList[r]){
                ints[i]=rightList[r];
                r++;
            }else {
                ints[i]=leftList[l];
                l++;
            }
        }
    }
}
