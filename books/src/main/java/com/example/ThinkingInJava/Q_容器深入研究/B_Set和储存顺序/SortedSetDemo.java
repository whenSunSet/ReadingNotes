package com.example.ThinkingInJava.Q_容器深入研究.B_Set和储存顺序;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 按对象的比较函数排序的Set，如TreeSet。可以用这个来对列表进行一些操作。
* */
public class SortedSetDemo {
    public static void main(String[] args) {
        HashMap map=new HashMap();
        SortedSet<String> sortedSet=new TreeSet<>();
        Collections.addAll(sortedSet,"One Two Three Four Five Six Seven Eight".split(" "));
        System.out.println(sortedSet);
        String low=sortedSet.first();
        String high=sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> iterator=sortedSet.iterator();
        for (int i = 0; i < 6; i++) {
            if (i==3)low=iterator.next();
            if (i==6)high=iterator.next();
            else iterator.next();
        }

        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
