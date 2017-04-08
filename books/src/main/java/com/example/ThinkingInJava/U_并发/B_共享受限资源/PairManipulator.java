package com.example.ThinkingInJava.U_并发.B_共享受限资源;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class PairManipulator implements Runnable{
    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true)
            pairManager.increment();
    }

    @Override
    public String toString() {
        return "Pair: "+ pairManager.getPair()+" checkCounter = "+ pairManager.checkCounter.get();
    }

}
