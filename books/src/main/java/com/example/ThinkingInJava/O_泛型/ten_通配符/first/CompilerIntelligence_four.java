package com.example.ThinkingInJava.O_泛型.ten_通配符.first;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 我们刚刚看见add方法是不能接受任何参数的，但是为什么像下面 的几个方法却又能接受参数呢？
* 这是由于：add()方法接受的参数是? extends Fruit，而下面这些方法接受的参数是Object。
*
* 这里也解决了一个疑惑：是不是add()方法是编译器特殊处理的呢？
* 其实不是，add()方法在接受的时候可能会接受到一个具体的泛型，那么此时他就会正常的工作。
* 当接受到? extends Fruit 这样的泛型的时候，编译器无法判断这个类到底是继承于Fruit的那个类，此时就会在编译期报错。
*
* */
public class CompilerIntelligence_four {
    public static void main(String[] args) {
        List<? extends Fruit> fruits= Arrays.asList(new Apple());
        Apple apple=(Apple) fruits.get(0);
        fruits.contains(new Apple());
        fruits.indexOf(new Apple());
    }
}
