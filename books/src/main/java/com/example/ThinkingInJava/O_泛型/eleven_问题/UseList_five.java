package com.example.ThinkingInJava.O_泛型.eleven_问题;

import java.util.List;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 泛型不能进行重载，还是由于泛型擦除
* */
public class UseList_five<W,T> {
//    void f(List<W> c){}
    void f(List<T> c){}
}
