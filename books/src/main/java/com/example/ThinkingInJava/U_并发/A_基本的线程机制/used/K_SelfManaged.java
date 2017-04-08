package com.example.ThinkingInJava.U_并发.A_基本的线程机制.used;

/**
 * Created by heshixiyang on 2017/2/4.
 */
/*
* 另一种方法是用Runnable自己管理自己的线程，得注意的是这里的start()是在构造器中调用的，
* 这就意味着该任务可能会在构造器结束之前访问到还没初始化完成的对象。
* */
public class K_SelfManaged implements Runnable {
    private int countDwon=5;
    private Thread thread=new Thread(this);

    public K_SelfManaged() {
        thread.start();
    }

    @Override
    public String toString() {

        return Thread.currentThread().getName()+"( "+countDwon+" )";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDwon==0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new K_SelfManaged();
        }
    }
}
