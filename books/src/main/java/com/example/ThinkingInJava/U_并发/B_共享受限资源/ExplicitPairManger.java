package com.example.ThinkingInJava.U_并发.B_共享受限资源;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class ExplicitPairManger extends PairManager {
    private Lock lock=new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try{
            pair.incrementY();
            pair.incrementX();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}
