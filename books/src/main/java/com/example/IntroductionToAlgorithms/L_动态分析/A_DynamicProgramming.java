package com.example.IntroductionToAlgorithms.L_动态分析;

/**
 * Created by heshixiyang on 2017/4/16.
 */

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * 1.某个问题的最优解由其子问题最优解组合而成
 * 2.递归地分解问题
 * 3.自底向上计算出被分解的子问题，并储存信息，以便复用子问题结果
 * 4.通过组合子问题来解决顶层问题
 */
public class A_DynamicProgramming {
    public static class Path{
        public int left;
        public int right;

        public Path(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static int[] gets=new int[1000];
    static Path[] path=new Path[1000];
    public static void main(String[] args) {
        int size=10;
        int[] A=Util.getRandomIntListHasBounder(size+1,21);
        A[0]=0;
        for (int i = 0; i < gets.length; i++) {
            gets[i]=-1;
        }
        gets[0]=0;
//        long time1=System.currentTimeMillis();
//        System.out.println(cutBarOne(size, A)+":"+(System.currentTimeMillis()-time1));
        long time2=System.currentTimeMillis();
        System.out.println(cutBarTwo(size, A)+":"+(System.currentTimeMillis()-time2));
        long time3=System.currentTimeMillis();
        System.out.println(cutBarThree(size, A)+":"+(System.currentTimeMillis()-time3));

        for (int i = 0; i < 10; i++) {
            System.out.println(fibnach(i));
        }
    }

    //钢条切割问题：暴力解决
    public static int cutBarOne(int n,int[] A){
        /**
         * cutBarOne(n,A)
         * if n==0
         *      return 0
         * q=MIN
         * for i=1 to n
         *      q=max(q,A[i]+cutBarOne(n-i,A))
         * return q
         */
        if (n==0)return 0;
        int q= Util.MIN;
        for (int i = 1; i <=n; i++) {
            q=Math.max(q,A[i]+cutBarOne(n-i,A));
        }
        return q;
    }

    //钢条切割问题：动态规划解决,递归,自顶向下
    public static int cutBarTwo(int n,int[] A){
        /**
         * cutBarTwo(n,A)
         * if n==0
         *      return 0
         * q=MIN
         * for i=1 to n
         *      temp=gets[n-i]
         *      if temp!=-1
         *          q=max(q,A[i]+temp)
         *      else
         *          q=max(q,A[i]+cutBarOne(n-i,A))
         * gets[n]=q
         * return q
         */
        if (n==0)return 0;
        int q= Util.MIN,left=0,right=0;
        for (int i = 1; i <=n; i++) {
            int temp=gets[n-i],tempQ=0;
            if (temp!=-1)
                tempQ=Math.max(q,A[i]+temp);
            else
                tempQ=Math.max(q,A[i]+cutBarTwo(n-i,A));
            if (tempQ>q){
                q=tempQ;
                left=i;
                right=n-i;
            }
        }
        path[n]=new Path(left,right);
        gets[n]=q;
        return q;
    }
    //钢条切割问题：动态规划解决,递归,自底向上
    public static int cutBarThree(int n,int[] A){
        /**
         * cutBarThree(n,A)
         * for i=1 to n
         *      q=MIN
         *      for j=1 to i
         *          if q<=A[j]+gets[i-j]
         *              q=A[j]+gets[i-j]
         *              left=j
         *              right=i-j
         *      path[i].left=left
         *      path[i].right=right
         *      gets[i]=q
         * return q
         */
        for (int i = 1; i<=n; i++) {
            int q=Util.MIN;
            int left = 0,right = 0;
            for (int j = 1; j <=i ; j++) {
                if (A[j]+gets[i-j]>=q){
                    q=A[j]+gets[i-j];
                    left=j;
                    right=i-j;
                }
            }
            path[i]=new Path(left,right);
            gets[i]=q;
        }
        return gets[n];
    }

    //15,1,3
    static int c=2;
    public static int cutBarThreeNeed(int n,int[] A){
        /**
         * cutBarThree(n,A)
         * for i=1 to n
         *      q=MIN
         *      for j=1 to i
         *          if q<=A[j]+gets[i-j]
         *              q=A[j]+gets[i-j]
         *              if i-j!=0
         *                  q=q-c
         *              left=j
         *              right=i-j
         *      path[i].left=left
         *      path[i].right=right
         *      gets[i]=q
         * return q
         */
        for (int i = 1; i<=n; i++) {
            int q=Util.MIN;
            int left = 0,right = 0;
            for (int j = 1; j <=i ; j++) {
                if (A[j]+gets[i-j]>=q){
                    q=A[j]+gets[i-j];
                    if (i-j!=0)q=q-c;
                    left=j;
                    right=i-j;
                }
            }
            path[i]=new Path(left,right);
            gets[i]=q;
        }
        return gets[n];
    }

    //15.1.5
    static int[] temp=new int[1000];
    public static int fibnach(int n){
        /**
         * fibnach(int n)
         * for i=1 to n-1
         *      num=temp[i-1]+temp[i]
         *      temp[i+1]=num
         * return num
         */
        int num=0;
        temp[0]=1;
        temp[1]=1;
        for (int i = 1; i <=n-1; i++) {
            num=temp[i-1]+temp[i];
            temp[i+1]=num;
        }
        return temp[n  ];
    }

}
