package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import com.example.ThinkingInJava.U_并发.B_共享受限资源.PairChecker;
import com.example.ThinkingInJava.U_并发.B_共享受限资源.PairManager;
import com.example.ThinkingInJava.U_并发.B_共享受限资源.PairManager1;
import com.example.ThinkingInJava.U_并发.B_共享受限资源.PairManager2;
import com.example.ThinkingInJava.U_并发.B_共享受限资源.PairManipulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* synchronized还能对某一段代码进行加锁，这样的好处是能让其他线程更多的访问另外的同步方法。
* 比如下面这个例子：
* 1.Pair的约束条件是x==y，当不符合的时候抛出异常。
* 2.此时有一个PairChecker线程用来循环检测x和y是否相等。
* 3.有一个PairManipulator线程对x和y进行循环递增。
* 4.PairManager中有一个和读取Pair的同步方法和一个递增x和y的抽象方法。
* 5.PairManager1将递增方法整个都同步，此时只要PairManipulator线程进入了递增方法，PairChecker线程就无法进行检测。
* 6.PairManager2只是将一部分代码同步，所以PairChecker线程就能有更多时间进行检测。
* 7.所以会出现PairManager2大于PairManager1的checkCounter。
* */
public class H_CriticalSection {
    static void testApproaches(PairManager pairManager1, PairManager pairManager2){
        ExecutorService executorService= Executors.newCachedThreadPool();
        PairManipulator
                pairManipulator1=new PairManipulator(pairManager1),
                pairManipulator2=new PairManipulator(pairManager2);
        PairChecker
                pairChecker1=new PairChecker(pairManager1),
                pairChecker2=new PairChecker(pairManager2);

        executorService.execute(pairManipulator1);
        executorService.execute(pairManipulator2);
        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println(("pairManipulator1: " + pairManipulator1 + "\n pairManipulator2: " + pairManipulator2));
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pairManager1 =new PairManager1(),
                pairManager2 =new PairManager2();
        testApproaches(pairManager1, pairManager2);
    }
}
