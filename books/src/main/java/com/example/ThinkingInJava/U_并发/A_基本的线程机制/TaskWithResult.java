package com.example.ThinkingInJava.U_并发.A_基本的线程机制;

import java.util.concurrent.Callable;

/**
 * Created by heshixiyang on 2017/2/4.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult "+id;
    }
}
