package com.example.ThinkingInJava.U_并发.B_共享受限资源;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            pair.incrementX();
            pair.incrementY();
            temp=getPair();
        }
        store(temp);
    }
}
