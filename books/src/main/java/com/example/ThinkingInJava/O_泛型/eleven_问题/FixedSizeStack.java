package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class FixedSizeStack<T> {
    private int index=0;
    private Object[] storage;

    public FixedSizeStack(int index) {
        this.index = index;
    }
    public void push(T item){
        storage[index++]=item;
    }
    public T pop(){
        return (T)storage[--index];
    }
}
