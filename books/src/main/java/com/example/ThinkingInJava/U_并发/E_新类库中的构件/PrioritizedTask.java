package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/7.
 */
public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask> {
    private Random random=new Random(47);
    private static int counter=0;
    private final int id=counter++;
    private final int priority;
    protected static List<PrioritizedTask> prioritizedTaskList=new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return priority<o.priority?1:(priority>o.priority?-1:0);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]",priority)+" Task "+id;
    }

    public String summary(){
        return "("+id+":"+priority+")";
    }
    public static class EndSentinel extends PrioritizedTask{
        private ExecutorService executorService;

        public EndSentinel(ExecutorService executorService) {
            super(-1);
            this.executorService = executorService;
        }

        @Override
        public void run() {
            int count=0;
            for (PrioritizedTask prioritizedTask:prioritizedTaskList){
                System.out.println(prioritizedTask.summary());
                if (++count%5==0)
                    System.out.println("");
            }
            System.out.println("");
            System.out.println((this + " Calling shutdownNow()"));
            executorService.shutdownNow();
        }
    }
}
