package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import com.example.U_并发.B_共享受限资源.ExplicitPairManger;
import com.example.U_并发.B_共享受限资源.ExplicitPairManger2;
import com.example.U_并发.B_共享受限资源.PairManager;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 还可以通过lock显式的加锁
* */
public class I_ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager
                pairManager1 =new ExplicitPairManger(),
                pairManager2 =new ExplicitPairManger2();
        H_CriticalSection.testApproaches(pairManager1, pairManager2);
    }
}
