package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

import java.util.LinkedHashMap;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 这个map是按插入顺序遍历该map，以散列插入。还可以在构造函数中设置参数，使其以LRU算法排序。
* 其获取的Set能体现出排序的方式。
* */
public class A_LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(1,"1");
        linkedHashMap.put(3,"3");
        linkedHashMap.put(5,"5");
        linkedHashMap.put(7,"7");
        linkedHashMap.put(9,"9");
        linkedHashMap.put(2,"2");
        linkedHashMap.put(4,"4");
        linkedHashMap.put(6,"6");
        linkedHashMap.put(8,"8");
        linkedHashMap.put(10,"10");

        System.out.println(linkedHashMap);

        linkedHashMap=new LinkedHashMap<>(1,0.75f,true);
        linkedHashMap.put(1,"1");
        linkedHashMap.put(3,"3");
        linkedHashMap.put(5,"5");
        linkedHashMap.put(7,"7");
        linkedHashMap.put(9,"9");
        linkedHashMap.put(2,"2");
        linkedHashMap.put(4,"4");
        linkedHashMap.put(6,"6");
        linkedHashMap.put(8,"8");
        linkedHashMap.put(10,"10");
        System.out.println(linkedHashMap);

        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }

        System.out.println(linkedHashMap);
        linkedHashMap.get(1);
        System.out.println(linkedHashMap);

        System.out.println(linkedHashMap.keySet());
    }
}
