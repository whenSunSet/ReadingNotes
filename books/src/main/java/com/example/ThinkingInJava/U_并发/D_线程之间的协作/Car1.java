package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Car1 {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean waxOn=false;

    public void waxed(){
        lock.lock();

        try {
            waxOn=true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed(){
        lock.lock();

        try {
            waxOn=false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn==false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn==true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}
