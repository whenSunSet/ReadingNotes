package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* volatile关键字保证被修饰的变量在一个线程中被改变之后就立即刷新主存中的数据，以保持各个线程对于该变量的读取是同一数据。
* */
public abstract class A_IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
