package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        this.in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(("Read: " + (char) in.read() + ","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
