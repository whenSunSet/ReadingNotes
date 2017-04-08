package com.example.ThinkingInJava.O_泛型.nine_边界.second;

/**
 * Created by heshixiyang on 2017/1/16.
 */
class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
