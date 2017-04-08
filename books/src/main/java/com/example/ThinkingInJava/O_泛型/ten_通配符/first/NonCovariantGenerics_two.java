package com.example.ThinkingInJava.O_泛型.ten_通配符.first;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 这里是会报错的，因为泛型和数组是不同的，数组是被完全定义的，在编译和运行期，就能对其进行检查。
* 而泛型是会被擦除的，编译器并不知道在运行期你会做什么事情，所以这里在编译期就直接不通过。
* 也就是说这种情况下不能向上转型。
* */
public class NonCovariantGenerics_two {
//    List<Fruit> fruits=new ArrayList<Apple>();
}
