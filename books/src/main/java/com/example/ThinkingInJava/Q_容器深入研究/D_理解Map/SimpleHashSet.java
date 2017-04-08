package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 练习
* */
public class SimpleHashSet<K> extends AbstractSet<K> {
    static final int SIZE=997;
    LinkedList<K>[] buckets=new LinkedList[SIZE];

    @Override
    public boolean add(K key) {
        int index=Math.abs(key.hashCode())%SIZE;
        if (buckets[index]==null)
            buckets[index]=new LinkedList<>();
        LinkedList<K> bucket=buckets[index];
        boolean found=false;
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).equals(key)){
                bucket.set(i,key);
                found=true;
                break;
            }
        }
        if (!found)
            buckets[index].add(key);
        return !found;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
