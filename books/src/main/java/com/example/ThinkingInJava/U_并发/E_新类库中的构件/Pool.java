package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by heshixiyang on 2017/2/7.
 */
/*
* 运行n个任务同时访问某资源，初始化时候设置n。
* semaphore.acquire()调用时，如果n==0，阻塞当前线程，直到n》0唤醒线程分配资源，再将n--
* semaphore.release()调用时，将n++，同时如果阻塞队列中有线程，那么唤醒一个。
* */
public class Pool<T> {
    private int size;
    private List<T> items=new ArrayList<>();
    private volatile  boolean[] checkedOut;
    private Semaphore semaphore;

    public Pool(Class<T> tClass,int size) {
        this.size = size;
        checkedOut= new boolean[size];
        semaphore=new Semaphore(size,true);
        for (int i = 0; i < size; i++) {
            try {
                items.add(tClass.newInstance());

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public T checkOut() throws InterruptedException {
        semaphore.acquire();
        return getItem();
    }

    public void checkIn(T x){
        if (releaseItem(x))
            semaphore.release();
    }

    private synchronized T getItem(){
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]){
                checkedOut[i]=true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item){
        int index=items.indexOf(item);
        if (index==-1)return false;
        if (checkedOut[index]){
            checkedOut[index]=false;
            return true;
        }
        return false;
    }
}
