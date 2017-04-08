package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Sender implements Runnable {
    private Random random=new Random(47);
    private PipedWriter out=new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true)
                for (char c='A';c<='z';c++){
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
