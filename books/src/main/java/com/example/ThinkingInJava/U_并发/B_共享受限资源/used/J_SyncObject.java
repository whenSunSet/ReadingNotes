package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;


import com.example.ThinkingInJava.U_并发.B_共享受限资源.DualSynch;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 在其他对象上同步：
* 在使用临界区块的时候，我们需要传入一个对象用来获取那个对象的锁。
* 所以一般情况下我们都是保证所有同步都是在本类中进行的，所以我们可以传入this
* 但是如果我们也可以传入其他对象，那么获取的就是其他对象的锁，这时候多个线程就能同时访问一个对象，因为锁不同。
* */
public class J_SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch=new DualSynch();
        new Thread(){
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
