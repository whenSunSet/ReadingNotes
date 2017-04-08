package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by heshixiyang on 2017/2/7.
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
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
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
