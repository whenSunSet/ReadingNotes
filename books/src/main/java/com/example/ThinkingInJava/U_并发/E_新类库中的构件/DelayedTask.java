package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class DelayedTask implements Runnable,Delayed {
    private static int counter=0;
    private final int id=counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> delayedTasks=new ArrayList<>();

    public DelayedTask(int delayInMillisecond) {
        delta=delayInMillisecond;
        trigger=System.nanoTime()+TimeUnit.NANOSECONDS.convert(delta,TimeUnit.MILLISECONDS);
        delayedTasks.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that=(DelayedTask)o;
        if (trigger<that.trigger)return -1;
        if (trigger>that.trigger)return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println((this + " "));
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]",delta);
    }

    public String summary(){
        return "("+id+":"+delta+")";
    }
    public static class EndSentinel extends DelayedTask{
        private ExecutorService executorService;

        public EndSentinel(int delayInMillisecond, ExecutorService executorService) {
            super(delayInMillisecond);
            this.executorService = executorService;
        }

        public void run(){
            for (DelayedTask delayedTask:delayedTasks){
                System.out.println((delayedTask.summary() + " "));
            }
            System.out.println("");
            System.out.println((this + " Calling shutdownNow()"));
            executorService.shutdownNow();
        }
    }
}
