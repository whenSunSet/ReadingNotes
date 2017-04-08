package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

import com.example.Q_容器深入研究.D_理解Map.Groundhog;
import com.example.Q_容器深入研究.D_理解Map.Prediction;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 如果我们使用自己定义的类型当作HashMap的键并且没有同时覆盖hashCode和equals方法时，那么你将会失败。
* 因为HashMap使用hashCode方法来生成插入时的散列数，然后通过equals方法来比较两个类的散列数是否相同。
* */
public class B_SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog=type.getConstructor(int.class);
        Map<Groundhog,Prediction> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i),new Prediction());
        }
        System.out.println(("map= " + map));
        Groundhog groundhog=ghog.newInstance(3);
        System.out.println(("Looking up prediction for " + groundhog));
        if (map.containsKey(groundhog))
            System.out.println(map.get(groundhog));
        else
            System.out.println(("key not found: " + groundhog));

    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
