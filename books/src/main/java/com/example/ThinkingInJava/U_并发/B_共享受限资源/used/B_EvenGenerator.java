package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;


import com.example.ThinkingInJava.U_并发.B_共享受限资源.EvenChecker;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 这里检验了当有多个线程访问一个共享变量的时候，中途可能会出现一个线程还没对这个变量改变完该线程就被挂起，
* 另一个线程来继续改变这个变量。
* */
public class B_EvenGenerator extends A_IntGenerator {
    private int currentEvenValue=0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new B_EvenGenerator());
    }
}
