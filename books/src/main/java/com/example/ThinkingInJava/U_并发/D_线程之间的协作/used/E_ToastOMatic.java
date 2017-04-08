package com.example.ThinkingInJava.U_并发.D_线程之间的协作.used;

import com.example.U_并发.D_线程之间的协作.Buttered;
import com.example.U_并发.D_线程之间的协作.Eater;
import com.example.U_并发.D_线程之间的协作.Jammer;
import com.example.U_并发.D_线程之间的协作.Toast;
import com.example.U_并发.D_线程之间的协作.Toaster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* 这是一个使用LinkedBlockingDeque优秀的例子，每个时刻只有各个线程能对这个队列进行操作，
* 其中的同步在内部完成，各个线程也会自动的挂起和恢复。
* */
public class E_ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        Toast.ToastQueue
                dryQueue=new Toast.ToastQueue(),
                butteredQueue=new Toast.ToastQueue(),
                finishedQueue=new Toast.ToastQueue();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Buttered(dryQueue,butteredQueue));
        executorService.execute(new Jammer(butteredQueue,finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
