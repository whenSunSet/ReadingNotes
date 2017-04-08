package com.example.ThinkingInJava.U_并发.C_终结任务.used;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 下面的例子演示了：一个任务被多次阻塞在一个锁上
* */
public class F_MultiLock {
    public synchronized void f1(int count){
        if (count-->0){
            System.out.println(("f1() calling f2() with count " + count));
            f2(count);
        }
    }
    public synchronized void f2(int count){
        if (count-->0){
            System.out.println(("f2() calling f1() with count " + count));
            f1(count);
        }
    }

    public static void main(String[] args) {
        final F_MultiLock FMultiLock =new F_MultiLock();
        new Thread(){
            @Override
            public void run() {
                FMultiLock.f1(10);
            }
        }.start();
    }
}
