package com.example.ThinkingInJava.O_泛型.ten_通配符.third;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 当有多个泛型参数，然后我们需要一个参数为任何类型的话，这时候无界通配符就会起作用。
* */
public class UnboundedWildcards_two {
    static Map map1;
    static Map<?,?>map2;
    static Map<String,?>map3;

    static void assign1(Map map){
        map1=map;
    }

    static void assign2(Map<?,?> map){
        map1=map;
    }

    static void assign3(Map<String,?> map){
        map1=map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        assign3(new HashMap());

        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());

    }
}
