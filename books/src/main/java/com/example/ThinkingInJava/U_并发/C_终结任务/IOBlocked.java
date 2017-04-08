package com.example.ThinkingInJava.U_并发.C_终结任务;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read()");
        try {
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked IO");
            }else {
                throw  new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
