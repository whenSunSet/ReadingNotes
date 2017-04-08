package com.example.ThinkingInJava.U_并发.C_终结任务.used;

import com.example.U_并发.C_终结任务.IOBlocked;
import com.example.U_并发.C_终结任务.SleepBlocked;
import com.example.U_并发.C_终结任务.SynchronizedBlocked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
/*
* 当我们在run()的中间被打断的时候(一般是被阻塞：io、sleep、获取锁失败)
* 我们就可以通过中断来停止该线程，而不是通过异常来使线程终止。
* 但是在这里我们只能中断sleep()的调用，而其他两个都不行。
* */
public class C_Interrupting {
    private static ExecutorService executorService= Executors.newCachedThreadPool();
    static void test(Runnable runnable) throws InterruptedException {
        Future<?> future=executorService.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(("Interrupting " + runnable.getClass().getSimpleName()));
        future.cancel(true);
        System.out.println(("Interrupt sent to " + runnable.getClass().getSimpleName()));
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
