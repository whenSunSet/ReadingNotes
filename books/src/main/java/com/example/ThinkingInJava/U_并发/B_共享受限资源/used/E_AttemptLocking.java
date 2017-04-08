package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* Lock有方法可以判断某个资源是否处于加锁状态，如果处于的话那么我们就不需要等待，而是其干别的事情，
* synchronized显然做不到这一点，只能让线程阻塞在那里。
* */
public class E_AttemptLocking  {
    private ReentrantLock lock=new ReentrantLock();
    public void untimed(){
        boolean captured=lock.tryLock();
        try {
            System.out.println(("tryLock(): " + captured));
        } finally {
            if (captured)
                lock.unlock();
        }

    }

    public void timed(){
        boolean captured=false;
        try {
            captured=lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(("tryLock(2,TimeUnit.SECONDS): " + captured));
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final E_AttemptLocking attemptLocking=new E_AttemptLocking();
        attemptLocking.untimed();
        attemptLocking.timed();
        new Thread(){
            {setDaemon(true);}
            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        attemptLocking.untimed();
        attemptLocking.timed();
    }
}
