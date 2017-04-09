package com.example.IntroductionToAlgorithms.G_快速排序;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/9.
 */
public class A_QuickSort {

    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        quickSort(A,0,9);
        Util.printList(A);

        quickSortDown(A,0,9);
        Util.printList(A);

        randomQuickSort(A,0,9);
        Util.printList(A);
    }

    public static void quickSort(int[] A,int start,int end){
        if (start<end){
            int middle=partition(A,start,end);
            quickSort(A,start,middle-1);
            quickSort(A,middle+1,end);
        }
    }

    public static int partition(int[] A,int start,int end){
        /**
         * partition(A,start,end)
         * x=A[end]
         * j=start-1
         * for i=start to end-1
         *      if A[i]<=x
         *          j++
         *          exchange A[j] with A[i]
         * exchange A[j+1] with A[end]
         * return j+1
         */

        int x=A[end],j=start-1;
        for (int i = start; i <end; i++) {
            if (A[i]<=x){
                j++;
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
            }
        }
        int temp=A[j+1];
        A[j+1]=A[end];
        A[end]=temp;
        return j+1;
    }

    //7.1.4
    public static void quickSortDown(int[] A,int start,int end){
        if (start<end){
            int middle=partitionDown(A,start,end);
            quickSortDown(A,start,middle-1);
            quickSortDown(A,middle+1,end);
        }
    }

    public static int partitionDown(int[] A,int start,int end){
        /**
         * partitionDown(A,start,end)
         * x=A[end]
         * j=start-1
         * for i=start to end-1
         *      if A[i]>=x
         *          j++
         *          exchange A[j] with A[i]
         * exchange A[j+1] with A[end]
         * return j+1
         */

        int x=A[end],j=start-1;
        for (int i = start; i <end; i++) {
            if (A[i]>=x){
                j++;
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
            }
        }
        int temp=A[j+1];
        A[j+1]=A[end];
        A[end]=temp;
        return j+1;
    }

    public static void randomQuickSort(int[] A, int start, int end){
        if (start<end){
            int middle= randomPartition(A,start,end);
            randomQuickSort(A,start,middle-1);
            randomQuickSort(A,middle+1,end);
        }
    }

    public static int randomPartition(int[] A, int start, int end){
        int i=Util.getRandomIntListHasBounder(1,end-start+1)[0];
        int temp=A[start+i-1];
        A[start+i-1]=A[end];
        A[end]=temp;
        return partition(A,start,end);
    }

}
