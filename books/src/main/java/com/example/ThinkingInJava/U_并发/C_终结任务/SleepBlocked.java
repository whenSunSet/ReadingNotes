package com.example.ThinkingInJava.U_并发.C_终结任务;

import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
