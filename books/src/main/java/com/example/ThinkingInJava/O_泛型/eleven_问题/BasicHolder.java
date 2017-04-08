package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class BasicHolder<T> {
    T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
