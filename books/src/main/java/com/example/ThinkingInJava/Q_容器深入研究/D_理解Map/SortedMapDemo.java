package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* t通过比较生成顺序的Map，类似于TreeSet
* */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> stringTreeMap=new TreeMap<>();
        stringTreeMap.put(1,"1");
        stringTreeMap.put(3,"3");
        stringTreeMap.put(5,"5");
        stringTreeMap.put(7,"7");
        stringTreeMap.put(9,"9");
        stringTreeMap.put(2,"2");
        stringTreeMap.put(4,"4");
        stringTreeMap.put(6,"6");
        stringTreeMap.put(8,"8");
        stringTreeMap.put(10,"10");

        System.out.println(stringTreeMap);

        Integer low=stringTreeMap.firstKey();
        Integer high=stringTreeMap.lastKey();

        System.out.println(low);
        System.out.println(high);

        Iterator<Integer> iterator=stringTreeMap.keySet().iterator();

        for (int i = 0; i < 6; i++) {
            if (i==3)low=iterator.next();
            if (i==6)high=iterator.next();
            else iterator.next();
        }

        System.out.println(low);
        System.out.println(high);

        System.out.println(stringTreeMap.subMap(low, high));
        System.out.println(stringTreeMap.headMap(high));
        System.out.println(stringTreeMap.tailMap(low));

    }
}
