package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import com.example.U_并发.B_共享受限资源.EvenChecker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 除了synchronized我们还可以用下面的方式
* 在lock()和unlock()之间我们创建了一个临界资源，同时只能有一个线程访问这个资源。
* 1.注意return必须在try里面，防止过早释放临界资源
* 2.使用Lock的好处就在于我们能处理某些异常，而使用synchronized我们无法对异常进行清理工作。
* */
public class D_MutexEvenGenerator extends A_IntGenerator {
    private int currentEvenValue=0;
    private Lock lock=new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
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
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new D_MutexEvenGenerator());
    }
}
