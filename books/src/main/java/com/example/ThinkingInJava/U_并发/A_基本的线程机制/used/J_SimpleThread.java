package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 可以直接继承Thread不用Runnable，构造器能为Thread命名
* */
public class J_SimpleThread extends Thread {
    private int countDown=5;
    private static int threadCount=0;

    public J_SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#"+getName()+"("+countDown+"),";
    }

    public void run(){
        while (true){
            System.out.println(this);
            if (--countDown==0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new J_SimpleThread();
        }
    }
}
