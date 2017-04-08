package com.example.ThinkingInJava.U_并发.D_线程之间的协作;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by heshixiyang on 2017/2/6.
 */
public class Toast {
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status=Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter(){
        status=Status.BUTTERED;
    }
    public void jam(){
        status=Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast "+id+": "+status;
    }

    public static class ToastQueue extends LinkedBlockingDeque<Toast>{}
}
