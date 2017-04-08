package com.example.IntroductionToAlgorithms.B_A_插入排序;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by heshixiyang on 2017/4/6.
 */
public class B_Test {
    public static void main(String[] args) {
        down();
        System.out.println("");
        search();
        System.out.println("");
        addBytes();
    }

    //2.1.2
    public static void down(){
        int[] ints= Util.getRandomIntListHasBounder(10,100);
        int key;
        /**
         从左到右降序
         * for j=2 to A.length
         *      key=A[j]
         *      for i=j-1 to 1 and A[i]<=key
         *          A[i+1]=A[i]
         *          A[i]=key
         */
        for (int j = 1; j < ints.length; j++) {
            key=ints[j];
            for (int i = j-1; i>=0&&ints[i]<=key; i--) {
                ints[i+1]=ints[i];
                ints[i]=key;
            }
        }
        Util.printList(ints);
    }

    //2.1.3
    public static void search(){
        int[] ints= Util.getRandomIntListHasBounder(10,1000);
        int v=Util.getRandomIntListHasBounder(1,100)[0];
        Util.printList(ints);
        System.out.println(v);
        /**
         * for i=1 to A.length and v==A[i]
         *      print i
         *      b=true
         *      break
         * if not b
         *      print NIL
         * 循环不变式：我们的预期是找到一个v在A中的i之后就跳出循环
         * 1.初始化：i=1的时候，如果A[1]和v相等，那么就直接找到了i。
         * 2.保持：对于A[i](1<i<=A.length)，只要在这个序列中找一个A[i]=v，那么循环就会结束
         * 3.终止：当i>A.length的时候，整个序列判断完毕，已经能判断出A中到底存不存在v
         */
        boolean b=false;
        for (int i = 0; i < ints.length && v==ints[i]; i++) {
            System.out.println(i);
            b=true;
            break;
        }
        if (!b) System.out.println("NIL");
    }

    //2.1.4
    public static void addBytes(){
        byte[] a=Util.getRandomByteListHasBounder(100,2);
        byte[] b=Util.getRandomByteListHasBounder(100,2);
        byte[] c=new byte[101];
        byte temp=0;
        /**
         * temp=0
         * for i=1 to a.length
         *      temp=a[i]+b[i]+temp
         *      switch temp
         *          0:
         *              c[i]=0
         *              break
         *          1:
         *              c[i]=1
         *              break
         *          2:
         *              c[i]=0
         *              temp=1
         *              break
         *          3:
         *              c[i]=1
         *              temp=1
         *              break
         *
         * c[c.length]=temp
         */

        for (int i = 0; i < a.length; i++) {
            temp= (byte) (a[i]+b[i]+temp);
            switch (temp){
                case 0:
                    c[i]=0;
                    break;
                case 1:
                    c[i]=1;
                    break;
                case 2:
                    c[i]=0;
                    temp=1;
                    break;
                case 3:
                    c[i]=1;
                    temp=1;
                    break;
            }
        }
        c[c.length-1]=temp;
        Util.printList(c);
    }
}
