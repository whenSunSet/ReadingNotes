package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.concurrent.DelayQueue;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> queue;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                queue.take().run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
