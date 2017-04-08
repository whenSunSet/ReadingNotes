package com.example.ThinkingInJava.O_泛型.ten_通配符.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 在一定情况下无界通配符，和原始类型是一致的。
* */
public class UnboundedWildcards_one {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;
    static void assign1(List list){
        list1=list;
        list2=list;
        list3=list;
    }
    static void assign2(List<?> list){
        list1=list;
        list2=list;
        list3=list;
    }
    static void assign3(List<? extends Object> list){
        list1=list;
        list2=list;
        list3=list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> list=new ArrayList<>();
        list=new ArrayList<String>();
        assign1(list);
        assign2(list);
        assign3(list);
    }
}
