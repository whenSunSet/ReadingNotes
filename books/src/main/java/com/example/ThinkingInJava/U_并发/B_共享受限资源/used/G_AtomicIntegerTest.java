package com.example.ThinkingInJava.U_并发.B_共享受限资源.used;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 我们可以使用原子类来对基本类型进行操作，这样消除了synchronized关键字，不过少用。
* */
public class G_AtomicIntegerTest implements Runnable{
    private AtomicInteger atomicInteger=new AtomicInteger();
    public int getValue(){
        return atomicInteger.get();
    }
    private void evenIncrement(){
        atomicInteger.addAndGet(2);
    }
    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        },5000);

        ExecutorService executorService= Executors.newCachedThreadPool();
        G_AtomicIntegerTest atomicIntegerTest=new G_AtomicIntegerTest();
        executorService.execute(atomicIntegerTest);

        while (true){
            int val=atomicIntegerTest.getValue();
            if (val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
