package com.example.IntroductionToAlgorithms.B_A_插入排序;

import com.example.V_算法.Util;

/**
 * Created by heshixiyang on 2017/2/10.
 */

/**
 * 插入排序：n*n
 * 类似于抽牌排序：
 * 1.j为所有牌的数量，第一个for循环相当于每次抽牌。
 * 2.i为手牌数量，第二个for相当于抽了一张牌之后，从右向左对手中的牌进行比较，找到空位插。一旦插入就跳出循环进行下一次抽牌。
 *
 * 循环不变式：对于一个循环，我们如何对这个循环进行判断，判断该循环会达到我们预期的效果
 * 1.初始化：第一次循环的时候是真的
 * 2.保持：如果某次循环的是真的，那么下一次循环其也是真的
 * 3.终止：循环结束，这一整个循环提供了一个性质，这个性质能证明算法是对的。
 *
 * 例如插入算法(从左到右升序)：我们的预期效果是将整个序列排好，每次循环的时候A的某段子序列都是有序的。
 * 1.初始化：j=2 i=1的时候，A[1]是我们预期的子序列，其是有序的
 * 2.保持：j=n i=n-1(n <=A.length)的时候，A[n]将要插入到A[n-1]这个子序列之中，
 * 于是在内部for循环中遍历A[n-1]并和A[n]进行比较，找到某个A[m](1=<m<=n-1)将A[n]放入A[m]中，
 * 然后让每个A[t](m<t<=n-1)向右移动一格。这样就完成了A[n]插入到A[n-1]中。
 * 3.终止：当j>A.length的时候，2结束了。此时子序列就是整个序列，所以整个序列已经排好，我们已经达到了预期。
 *
 * */
public class  A_InsertionSort {
    public static void main(String[] args) {
        int[] ints= Util.getRandomIntListHasBounder(10,100);
        int key;

        /**
         * 从左到右升序
         * for j=2 to A.length
         *      key=A[j]
         *      for i=j-1 to 1 and A[i]>=key
         *          A[i+1]=A[i]
         *          A[i]=key
         */

        for (int j = 1; j < ints.length; j++) {
            key=ints[j];
            for (int i = j-1; i >=0&&ints[i]>=key; i--) {
                ints[i+1]=ints[i];
                ints[i]=key;
            }
        }
        Util.printList(ints);


    }
}
