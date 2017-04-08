package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 先来了解一下java的内存模型：
* 1.每个线程有自己的共享变量副本(实例域、静态域、数组元素)
* 2.Java线程之间的通讯由java内存模型控制(JMM)，JMM决定了一个线程对共享变量的写入在什么时候对另一个线程可见。
* 3.当一个A线程改变了一个共享变量，此时只是改变了自己本地共享变量的副本，所以线程之间要实现通讯需要先将A线程的本地副本
* 刷入到主存之中，然后线程B去主存中读取线程A刷入的改变的变量。
*
* 原子性：是指某一条代码转化成指令之后依然是一条指令。
* 1.除了long和double，其他基本类型的简单操作都是原子性操作：读取、写入数字。
* 2.java1.5之后使用volatile关键字能够让long和double像其他基本类型一样。
* 3.不能因为有原子性，就放弃同步。
* 4.volatile关键字还保证了，某个共享变量改变之后，另一个线程中本地共享变量的副本也会立即刷新。
* 5.synchronized也有volatile关键字一样的效果。
* 6.当某个域的值依赖于它之前的值，如计数递增那么volatile就会失效。
* 7.使用volatile而不使用synchronized的唯一情况就是类中只有一个可变域，其他时候都应该使用synchronized。
*
* 下面的例子的含义是：
* 虽然return i是一个原子操作，但是在运行过程之中，可能F_AtomicityTest线程中的i还没来得及刷新到main线程中
* 就已经被getValue()了，此时就会让程序退出，这也说明了原子性不可靠.(虽然运行了十几分钟，但是依然没有出现书中的情况。)
* */
public class F_AtomicityTest implements Runnable {
    private int i=0;
    public int getValue(){
        return i;
    }
    public synchronized void evenIncrement(){
        for (int i = 0; i < 10000; i++) {
            i++;
        }
    }
    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        F_AtomicityTest atomicityTest=new F_AtomicityTest();
        executorService.execute(atomicityTest);
        while (true){
            int val=atomicityTest.getValue();
            if (val%10000!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
