package com.example.ThinkingInJava.Q_容器深入研究.F_持有引用;

import java.util.WeakHashMap;

/**
 * Created by heshixiyang on 2017/1/22.
 */
public class CanonicalMapping {
    public static void main(String[] args) {
        int size=1000;
        if (args.length>0)
            size=new Integer(args[0]);
        Key[] keys=new Key[size];
        WeakHashMap<Key,Value> map=new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key key=new Key(Integer.toString(i));
            Value value =new Value(Integer.toString(i));
            if (i%3==0)
                keys[i]=key;
            map.put(key,value);
        }
        System.gc();
    }
}
