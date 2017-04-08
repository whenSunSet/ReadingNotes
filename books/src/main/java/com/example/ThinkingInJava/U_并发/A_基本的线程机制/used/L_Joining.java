package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 在A线程中调用了B线程的join，那么就会先执行完B线程然后再继续执行A线程
* */
public class L_Joining {
    public static class Sleeper extends Thread{
        private int duration;

        public Sleeper(String name, int duration) {
            super(name);
            this.duration = duration;
            start();
        }

        @Override
        public void run() {

            try {
                sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((getName() + "has awakened"));
        }
    }

    public static class Joiner extends Thread{
        private Sleeper sleeper;

        public Joiner(String name, Sleeper sleeper) {
            super(name);
            this.sleeper = sleeper;
            start();
        }

        @Override
        public void run() {
            try {
                sleeper.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((getName() + "join completed"));
        }
    }

    public static void main(String[] args) {
        Sleeper sleeper =new Sleeper("Sleeper",1500),
                grumpy=new Sleeper("Grumpy",1500);

        Joiner dopey=new Joiner("Dopey",sleeper),
                doc=new Joiner("Doc",grumpy);

        grumpy.interrupt();
    }
}
