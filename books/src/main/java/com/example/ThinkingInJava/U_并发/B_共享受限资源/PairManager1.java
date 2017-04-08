package com.example.ThinkingInJava.U_并发.B_共享受限资源;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}
