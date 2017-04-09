package com.example.IntroductionToAlgorithms.I_中位数和顺序统计量;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/9.
 */
public class Select {
    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        System.out.println(select(A, 0, 9, 3));
    }

    public static int select(int[] A,int start,int end,int i){
        /**
         * middle=partition(A,start,end)
         * if middle<i
         *      select(A,int middle+1,end,i)
         * if middle>i
         *      select(A,start，middle-1,i)
         * if middle==i
         *      return A[middle]
         */
        int middle=partition(A,start,end);
        if (middle<i)return select(A,middle+1,end,i);
        else if (middle>i)return select(A,start,middle-1,i);
        else return A[middle];
    }

    public static int partition(int[] A,int start,int end){
        /**
         * partition(A,start,end)
         * x=A[end]
         * j=start-1
         * for i=start to end-1
         *      if A[i]<=x
         *          j++
         *          exchange A[i] with A{j]
         * exchange A[j++] with A[end]
         * return j+1
         */

        int x=A[end],j=start-1;
        for (int i = start; i <=end-1; i++) {
            if (A[i]<=x){
                j++;
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        int temp=A[end];
        A[end]=A[j+1];
        A[j+1]=temp;
        return j+1;
    }
}
