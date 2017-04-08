package com.example.ThinkingInJava.O_泛型.ten_通配符.second;

import com.example.O_泛型.ten_通配符.first.Apple;
import com.example.O_泛型.ten_通配符.first.Fruit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
public class GenericReading_three {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static List<Apple> apples= Arrays.asList(new Apple());
    static List<Fruit> fruits= Arrays.asList(new Fruit());

    static void  f1(){
        Apple apple=readExact(apples);
        Fruit f=readExact(fruits);
        f=readExact(apples);
    }
    static class Reader<T>{
        T readExact(List<T> list){return list.get(0);}
    }
    static void f2(){
        Reader<Fruit> fruitReader=new Reader<>();
//        Fruit fruit=fruitReader.readExact(apples);
    }

    static class CovariantReader<T>{
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }
    static void f3(){
        CovariantReader<Fruit> fruitCovariantReader=new CovariantReader<>();
        Fruit fruit=fruitCovariantReader.readCovariant(fruits);
        Fruit a=fruitCovariantReader.readCovariant(apples);
    }

}
