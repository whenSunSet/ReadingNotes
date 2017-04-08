package com.example.ThinkingInJava.O_泛型.ten_通配符.second;

import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Apple;
import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 这里书上认为f1中不能将Apple放入fruits中，但是这里却是可行的。
* */
public class GenericWriting_two {
    static <T> void writeExact(List<T> list,T item){
        list.add(item);
    }
    static List<Apple> apples=new ArrayList<Apple>();
    static List<Fruit> fruits=new ArrayList<Fruit>();
    static void f1(){
        fruits.add(new Apple());
        writeExact(apples,new Apple());
        writeExact(fruits,new Apple());
    }

    static <T> void writeWildcard(List<? super T> list,T item){
        list.add(item);
    }
    static void f2(){
        writeWildcard(apples,new Apple());
        writeWildcard(fruits,new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
