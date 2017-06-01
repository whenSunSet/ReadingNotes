package com.example.IntroductionToAlgorithms;

import java.lang.ref.WeakReference;
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     *
     *

     小张和朋友合伙开了一个超市，并向供应商订购了数百种商品准备上架。超市的商品需要分类摆放便于管理。每类商品都有一个8位编码，
     其中前三位数字是一级类目，第四位和第五位是英文数字，表示二级类目，后三位是数字 ，表示三级类目。
     小明用扫码机录入所有商品的信息，要求将商品根据条码信息分门别类按序排列，为商品上架做出指导。

     规则为依次按一、二、三级排序。

     首先：第一级按数字正序，从小到大，

     其次：第二级按字母倒序，从后到前，

     最后：第三级按数字倒序，从大到小。
     **/
    static String process(String input) {
        String[] nums=input.split(",");
        int[] one=new int[nums.length];
        char[][] two=new char[nums.length][2];
        int[] three=new int[nums.length];
        int[] four=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            one[i]=Integer.valueOf(nums[i].substring(0,3));
            two[i]=nums[i].substring(3,5).toCharArray();
            three[i]=Integer.valueOf(nums[i].substring(5,8));
            four[i]=(two[i][0]-'A'+1)*26+(two[i][1]-'A'+1);
        }

        quickSort(one,0,one.length-1,nums);
        quickSortDown(four,0,one.length-1,nums);
        quickSortDown(three,0,one.length-1,nums);

        String an="";
        for (int i = 0; i < nums.length-1; i++) {
            an=an+nums[i]+",";
        }
        an=an+nums[nums.length-1];
        return an;
    }

    public static class One{
        public Two two;

        public One(Two two) {
            this.two = two;
        }
    }
    public static class Two{
        public One one;

        public Two(One one) {
            this.one = one;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = process(_input);
        System.out.println(res);

        byte[] one=new byte[1];
        byte[] two=new byte[1024*1024*1024];
        One one1=new One(null);
        Two two1=new Two(null);
        one1.two=two1;
        two1.one=one1;
        WeakReference<Byte[]> wOne = new WeakReference(one);
        WeakReference<Byte[]> wTwo= new WeakReference(two);
        WeakReference<One> wOne1= new WeakReference(one1);
        WeakReference<Two> wTwo1= new WeakReference(two1);
        one=null;
        two=null;
        one1=null;
        two1=null;
        System.out.println(wOne.get()==null);
        System.out.println(wTwo.get()==null);
        System.out.println(wOne1.get()==null);
        System.out.println(wTwo1.get()==null);

        System.gc();
        System.out.println(wOne.get()==null);
        System.out.println(wTwo.get()==null);
        System.out.println(wOne1.get()==null);
        System.out.println(wTwo1.get()==null);
    }

    public static void quickSort(int[] A,int start,int end,String[] nums){
        if (start<end){
            int middle=partition(A,start,end,nums);
            quickSort(A,start,middle-1,nums);
            quickSort(A,middle+1,end,nums);
        }
    }

    public static int partition(int[] A,int start,int end,String[] nums){
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
                String  tempS=nums[j];
                A[j]=A[i];
                A[i]=temp;
                nums[j]=nums[i];
                nums[i]=tempS;
            }
        }
        int temp=A[j+1];
        String tempS=nums[j+1];
        A[j+1]=A[end];
        A[end]=temp;
        nums[j+1]=nums[end];
        nums[end]=tempS;
        return j+1;
    }


    public static void quickSortDown(int[] A,int start,int end,String[] nums){
        if (start<end){
            int middle=partitionDown(A,start,end,nums);
            quickSortDown(A,start,middle-1,nums);
            quickSortDown(A,middle+1,end,nums);
        }
    }

    public static int partitionDown(int[] A,int start,int end,String[] nums){
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
                String  tempS=nums[j];
                A[j]=A[i];
                A[i]=temp;
                nums[j]=nums[i];
                nums[i]=tempS;
            }
        }
        int temp=A[j+1];
        String tempS=nums[j+1];
        A[j+1]=A[end];
        A[end]=temp;
        nums[j+1]=nums[end];
        nums[end]=tempS;
        return j+1;
    }
// 示例输入1
// 004HI090,004HI091,004HZ091,004KY026

// 示例输入2
// 004HI090,004HI091,004HZ091,004KY026,030HY018,007GY010,038QA066,004IE071,036PE075,029FA070,038NY002,024DV074,008VR058,008JK081,034GS085,020JH083,038HM003,035IJ091,027CB088,003PH003,039RE044,020CB082,029JX074,034JT078,012AO079,029BN015,013UK028,024MP012,018UX080,013AY033


}