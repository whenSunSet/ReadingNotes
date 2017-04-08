package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

import java.util.Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
public class MapEntry<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value=value;
        return value;
    }

    @Override
    public int hashCode() {
        return (key==null?0:key.hashCode())^(value==null?0:value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry))return false;
        MapEntry mapEntry=(MapEntry)obj;
        return (key==null?mapEntry.getKey()==null:key.equals(mapEntry.getKey()))&&
                (value==null?mapEntry.getValue()==null:value.equals(mapEntry.getValue()));
    }
}
