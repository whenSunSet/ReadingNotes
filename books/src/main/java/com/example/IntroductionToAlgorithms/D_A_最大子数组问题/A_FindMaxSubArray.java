package com.example.IntroductionToAlgorithms.D_A_最大子数组问题;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/6.
 */
public class A_FindMaxSubArray {
    public static class Bean{
        int low;
        int high;
        int sum;

        public Bean(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "low=" + low +
                    ", high=" + high +
                    ", sum=" + sum +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2!=1)A[i]=-A[i];
        }
        Util.printList(A);
        System.out.println(findMaxSubArray(A, 0, A.length - 1));
    }

    /**
     * 对于最大子数组问题：
     * 1.将数组分为左和右，只要找出左、右、或左右之间三个地方的最大子数组就可以解决当前数组的最大子数组
     * 2.对于数组当分解成为1的时候就直接返回到上一层。在上一层左右就确定了，那么此时就只要找中间的最大子数组
     * 3.在2的基础上，当某个层级的最大子数组确定了，那么就表示其上一层的左或右的最大子数组确定了，此时每一层就只要
     * 找到中间的最大子数组就行了。
     * @param A
     * @param start
     * @param end
     * @return
     */
    public static Bean findMaxSubArray(int[] A,int start,int end){
        if (start==end)return new Bean(start,end,A[start]);
        int middle=(start+end)/2;
        Bean leftBean,rightBean,middleBean;
        leftBean=findMaxSubArray(A,start,middle);
        rightBean=findMaxSubArray(A,middle+1,end);
        middleBean=findCrossingMaxSubArray(A,start,middle,end);
        if (leftBean.sum>=rightBean.sum&&leftBean.sum>=middleBean.sum)return leftBean;
        else if (rightBean.sum>=leftBean.sum&&rightBean.sum>=middleBean.sum)return rightBean;
        else if (middleBean.sum>=leftBean.sum&&middleBean.sum>=rightBean.sum)return middleBean;
        return null;
    }

    public static Bean findCrossingMaxSubArray(int[] A,int start,int middle,int end){
        /**
         * findCrossingMaxSubArray(A,start,middle,end)
         * leftSum=MIN
         * rightSum=MIN
         * l=0
         * r=0
         * temp=0
         *
         * for j=middle to start
         *      temp=temp+A[j]
         *      if temp>=leftSum
         *          leftSum=temp
         *          l=j
         * for j=middle to end
         *      temp=temp+A[j]
         *      if temp>=rightSum
         *          rightSum=temp
         *          r=j
         * return (l,r,leftSum+rightSum)
         */

        int leftSum=Util.MIN,rightSum=Util.MIN,l=0,r=0,temp=0;
        for (int i = middle; i>=start; i--) {
            temp=temp+A[i];
            if (temp>=leftSum){
                leftSum=temp;
                l=i;
            }
        }
        for (int i = middle; i<=end; i++) {
            temp=temp+A[i];
            if (temp>=rightSum){
                rightSum=temp;
                r=i;
            }
        }
        return new Bean(l,r,leftSum+rightSum);
    }
}
