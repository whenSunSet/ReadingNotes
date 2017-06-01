package com.example.IntroductionToAlgorithms;

/**
 * Created by heshixiyang on 2017/4/24.
 */
public class A_Solution {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */

    /**
     题目描述
     世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
     输入例子:
     1999 2299
      11111001111
     100011111011
     输出例子:
     7

     16807 282475249
                   100000110100111
     10000110101100011101011110001
     */
    public static int countBitDiff(int m, int n) {
        Result[] mResult=new Result[32];
        Result[] nResult=new Result[32];

        int temp=0;
        if (m>=n)temp=m;
        else temp=n;

        for (int i = 0; i < 32; i++) {
            mResult[i]=new Result((byte) 0,0);
            nResult[i]=new Result((byte) 0,0);
        }

        int times=0;
        while (temp>0){

            if (m!=0){
                mResult[times]=new Result((byte) (m%2==1?1:0),m/2);
            }
            if (n!=0){
                nResult[times]=new Result((byte) (n%2==1?1:0),n/2);
            }
            m=m/2;
            n=n/2;
            temp=temp/2;
            times++;
        }

        int comom=0;
        for (int i = 0; i < 32; i++) {
            if (mResult[i].end==nResult[i].end)comom++;
        }
        return 32-comom;
    }

    public static class Result{
        byte end;
        int result;

        public Result() {
        }

        public Result(byte end, int result) {
            this.end = end;
            this.result = result;
        }
    }

    public static void main(String[] args) {
        System.out.println(countBitDiff(16807,282475249));
    }
}
