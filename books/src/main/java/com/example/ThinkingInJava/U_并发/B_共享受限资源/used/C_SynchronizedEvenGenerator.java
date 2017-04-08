package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;


import com.example.ThinkingInJava.U_并发.B_共享受限资源.EvenChecker;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 为了解决一个线程对一个变量的处理还没完成，另一个线程又来处理这个变量的问题，java使用了synchronized关键字。
* 1.synchronized可以用于修饰方法，在某线程从某个用synchronized修饰的方法返回之前，其他所有要调用这个对象中任意使用synchronized修饰的方法的线程都会被阻塞。
* 即同一时刻某个对象中只能有一个synchronized修饰的方法被调用。
* 2.所以我们可以将某个共享变量设置为private，并且将其访问方法设置为synchronized，这样就能防止B中的情况发生。
* 3.对于某个对象，其所有synchronized方法共享一把锁，也就是说一个对象中含有一把锁(也叫监视器)，所以才会有上面两个结论。
* 4.一个线程可以多次获取某个对象的锁，比如一个synchronized方法中调用了该对象中另一个synchronized方法，
* 那么这个锁的计数就会变成2，每从一个synchronized方法离开都会使计数减一，没进入一个synchronized方法都会使计数加一。
* 5.每个类也有一把锁(属于类的Class的一部分)，所以synchronized static可以防止类范围内对于static数据的并发访问。
*
* */
public class C_SynchronizedEvenGenerator extends A_IntGenerator {
    private int currentEvenValue=0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new C_SynchronizedEvenGenerator());
    }
}
