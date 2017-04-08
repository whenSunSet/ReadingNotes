package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/7.
 */
public class PrioritizedTaskProducer implements Runnable {
    private Random random=new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService executorService;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService executorService) {
        this.queue = queue;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(executorService));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing PrioritizedTaskProducer");
    }
}
