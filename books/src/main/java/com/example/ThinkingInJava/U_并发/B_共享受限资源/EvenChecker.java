package com.example.ThinkingInJava.U_并发.B_共享受限资源;

import com.example.ThinkingInJava.U_并发.B_共享受限资源.used.A_IntGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class EvenChecker implements Runnable {
    private A_IntGenerator generator;
    private final int id;

    public EvenChecker(int id, A_IntGenerator generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            long val=generator.next();
            if (val%10!=0){
                System.out.println((val + " not event"));
                generator.cancel();
            }
        }
    }

    public static void test(A_IntGenerator g,int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(i,g));
        }
        executorService.shutdown();
    }

    public static void test(A_IntGenerator g){
        test(g,10);
    }
}
