package com.example.IntroductionToAlgorithms.D_A_最大子数组问题;

import com.example.IntroductionToAlgorithms.util.CapabilityTest;
import com.example.IntroductionToAlgorithms.util.ListParams;
import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class B_Test {
    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2!=1)A[i]=-A[i];
        }
        Util.printList(A);
        System.out.println(findMaxSubArrayTwo(A));

//        compare();

        System.out.println(findMaxSubArrayThree(A));
    }

    //4.1.2
    public static A_FindMaxSubArray.Bean findMaxSubArrayTwo(int[] A){
        /**
         * findMaxSubArrayTwo(A)
         * sum=MIN
         * l=0
         * r=0
         * for j=1 to A.length
         *      temp=0
         *      for i=j to A.length
         *            temp=temp+A[i]
         *            if temp>=sum
         *              sum=temp
         *              l=j
         *              r=i
         * return (l,r,sum)
         */

        int sum=Util.MIN,l=0,r=0,temp;
        for (int j = 0; j < A.length; j++) {
            temp=0;
            for (int i = j; i < A.length; i++) {
                temp=temp+A[i];
                if (temp>=sum){
                    sum=temp;
                    l=j;
                    r=i;
                }
            }
        }
        return new A_FindMaxSubArray.Bean(l,r,sum);
    }

    //4.1.3
    public static void compare(){
        CapabilityTest.getPerformanceOFTheIntersection(new CapabilityTest.Algorithm() {
            @Override
            public void action(Object o, int[] A) {
                ListParams listParams = (ListParams) o;
                A_FindMaxSubArray.findMaxSubArray(A, listParams.getStart(), listParams.getEnd());
            }
        }, new CapabilityTest.Algorithm() {
            @Override
            public void action(Object o, int[] A) {
                findMaxSubArrayTwo(A);
            }
        });
    }

    //4.1.5
    public static A_FindMaxSubArray.Bean findMaxSubArrayThree(int[] A){
        /**
         * 查找时间为n的最大子数组查找方式解释：
         * 1.最大子数组第一个元素一定是正数
         * 2.将A中连续的正数和负数合并，此时A数组就变成了一正一负间隔
         * 3.从左开始，开头的负数可以去掉，此时最大子数组的判断就变成了:
         *      1.从正1到正2之间的负1和正1的绝对值大小
         *      2.单独的正1和正2谁大
         * 这两个条件的判断。会有以下几种结果：
         *      1.负1绝对值大于正1且正1大于正2，那么正2这一对就可以跳过
         *      2.负1绝对值小于正1，那么最大子数组就包括了正1和正2这两对
         *      3.负1绝对值大于正1且正1小于正2，那么正1就可以跳过，最大子数组不包括正1这一对
         *
         * findMaxSubArrayThree(A)
         * sum=MIN
         * temp=0
         * l=1
         * r=1
         * tl=1
         * for j=1 to A.length
         *      temp=temp+A[j]
         *      if temp>=sum
         *          sum=temp
         *          r=j
         *          if tl>l
         *              l=tl
         *      if temp<=0
         *          temp=0
         *          tl=j
         *
         */
        int sum=Util.MIN,temp=0,l=1,r=1,tl=1;
        for (int i = 0; i < A.length; i++) {
            temp=temp+A[i];
            if (temp>=sum){
                sum=temp;
                r=i;
                if (tl>l)l=tl;
            }
            if (temp<=0){
                temp=0;
                tl=i;
            }
        }
        return new A_FindMaxSubArray.Bean(l,r,sum);
    }
}
