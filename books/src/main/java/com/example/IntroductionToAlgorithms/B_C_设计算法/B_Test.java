package com.example.IntroductionToAlgorithms.B_C_设计算法;


import com.example.IntroductionToAlgorithms.Util;

/**
 * Created by heshixiyang on 2017/4/6.
 */
public class B_Test {
    public static void main(String[] args) {
        int[] ints= Util.getRandomIntListHasBounder(4,100);

//        mergeSort(ints,0,ints.length-1);
//        Util.printList(ints);
//
//        int v=93;
//        if (!search(v,ints,0,(ints.length-1)/2,ints.length-1)) System.out.println("NIL");
//
//        if (test1(ints,v)) System.out.println("has");
//        else System.out.println("has not");

        System.out.println(testSort(ints, 0, ints.length - 1));
    }

    //2.3.2
    public static void mergeSort(int[] ints, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(ints, start, middle);
            mergeSort(ints, middle + 1, end);
            mergeTwo(ints, start, middle, end);
        }
    }

    //2.3.2
    public static void mergeTwo(int[] ints, int start, int middle, int end) {
        /**
         * merge(A,start,middle,end)
         * n1=middle-start+1
         * n2=end-middle
         * let L[1..n1] and R[1..n2] to be array
         * for j=1 to n1
         *      L[j]=A[start+j-1]
         * for j=1 to n2
         *      R[j]=A[middle+j]
         * l=1;
         * r=1;
         * rightFinish=false
         * for j=start to end
         *      if L[l]>=R[r]
         *          A[j]=R[r]
         *          r++
         *          if r==n2+1
         *              rightFinish=true
         *              break
         *      else
         *          A[j]=L[l]
         *          l++
         *          if l==n1+1
         *              break
         * for i=j to end
         *      if rightFinish
         *          A[i]=L[l]
         *          l++
         *      else
         *          A[i]=R[r]
         *          r++
         */

        int lengthLeft=middle-start+1;
        int lengthRight=end-middle;

        int[] leftList=new int[lengthLeft];
        int[] rightList=new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++) {
            leftList[i]=ints[start+i];
        }

        for (int i = 0; i <lengthRight; i++) {
            rightList[i]=ints[middle+1+i];
        }

        int l=0,r=0,j;
        boolean rightFinished=false;
        for (j = start; j <=end ; j++) {
            if (leftList[l]>=rightList[r]){
                ints[j]=rightList[r];
                r++;
                if (r==lengthRight){
                    rightFinished=true;
                    break;
                }
            }else {
                ints[j]=leftList[l];
                l++;
                if (l==lengthLeft) break;
            }
        }

        for (int i = j+1; i <=end; i++) {
            if (rightFinished){
                ints[i]=leftList[l];
                l++;
            }else {
                ints[i]=rightList[r];
                r++;
            }
        }
    }
    //2.3.5 递归二分查找
    public static boolean search(int v,int[] A,int start,int middle,int end){

        /**
         * search(v,A,start,middle,end)
         * if start<end
         *      if A[middle]==v
         *          print middle
         *          return true
         *      if A[middle]<v
         *          search(v,A,middle+1,(end+middle+1)/2,end)
         *      if A[middle]>v
         *          search(v,A,start,(middle+start)/2,middle)
         * else
         *      if A[middle]==v
         *          print middle
         *          return true
         *      else
         *          return false
         */
        if (start<end){
            if (A[middle]==v){
                System.out.println(middle);
                return true;
            }else if (A[middle]<v){
                return search(v,A,middle+1,(end+middle+1)/2,end);
            }else {
                return search(v,A,start,(middle+start)/2,middle);
            }
        }else{
            if (A[middle]==v){
                System.out.println(middle);
                return true;
            }else return false;
        }
    }
    //2.3.7 一个A和v，在数组A中找到两个数的和是v
    public static boolean test1(int[] A,int v){
        /**
         * test(A,v)
         * mergeSort(A,1,A.length)
         * i=1
         * j=A.length
         * temp=0
         * while i<=j
         *      temp=A[i]+A[j]
         *      if temp>v
         *          j--
         *      else if temp<v
         *          i++
         *      else
         *          return true
         * return false
         */
        mergeSort(A,0,A.length-1);
        int i=0,j=A.length-1,temp;
        while (i<=j){
            temp=A[i]+A[j];
            if (temp>v)j--;
            else if (temp<v)i++;
            else return true;
        }
        return false;
    }

    //2.4
    //b:全部反着来
    //c:全部反着来的时候，插入排序需要的时间最多，顺着来时间最少。
    //d:找逆序对
    public static int test2(int[] A,int start,int middle,int end){
        /**
         * test(A,start,middle,end)
         * n1=middle-start+1
         * n2-end-middle
         * let L[1..n1+1] and R[1..n2+1] to be new arrays
         * for j=1 to n1
         *      L[j]=A[start+j-1]
         * for j=1 to n2
         *      R[j]=A[middle+j]
         * L[n1+1]=MAX
         * R[n2+1]=MAX
         * l=1
         * r=1
         * num=0
         * for j=start to end
         *      if L[l]<=R[r]
         *          A[j]=L[l]
         *          l++
         *      else
         *          num=n2-l+1+num
         *          A[j]=R[r]
         *          r++
         * return num
         */

        int lengthLeft=middle-start+1;
        int lengthRight=end-middle;

        int[] leftList=new int[lengthLeft+1];
        int[] rightList=new int[lengthRight+1];

        for (int i = 0; i < lengthLeft; i++) {
            leftList[i]=A[start+i];
        }

        for (int i = 0; i <lengthRight; i++) {
            rightList[i]=A[middle+1+i];
        }

        leftList[lengthLeft]=Util.MAX;
        rightList[lengthRight]=Util.MAX;

        int l=0,r=0,num=0;
        for (int i = start; i <=end; i++) {
            if (leftList[l]<=rightList[r]){
                A[i]=leftList[l];
                l++;
            }else {
                num=lengthLeft-l+num;
                A[i]=rightList[r];
                r++;
            }
        }
        return num;
    }

    //2.4
    public static int testSort(int[] ints, int start, int end) {
        int num=0;
        if (start < end) {
            int middle = (start + end) / 2;
            num=num+testSort(ints, start, middle);
            num=num+testSort(ints, middle + 1, end);
            num=num+test2(ints, start, middle, end);
        }
        return num;
    }
}