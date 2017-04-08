package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;


import com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.MapEntry;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 这里可以解释一个之前产生的疑问，为什么自己创建的类要同时覆盖equals和hashCode方法才能作为键。
* 1.hashCode的方法是为了提供一个散列数，如果我们不覆盖的话，那么由系统随机产生的散列数基本上不会产生重复，
* 所以如果我们区分键的方式是由对象中的某几个参数的话，虽然那几个参数会相同，但是散列数不同，所以永远找不到槽位。
* 2.hashCode方法是为了让我们找到槽位，equals方法则是让我们获取到具体的键的位置，因为一个槽位可能会有多个键，
* 而默认equals方法只是比较对象的地址，所以像上面一样如果我们区分键的方式是由对象中的某几个参数的话，那么就永远找不到具体的键。
*
* put:取Key的hashCode的绝对值对SIZE取模获取到槽位，若槽位为空创建槽位，然后将键值对放入。
* */
public class F_SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE=997;
    LinkedList<MapEntry<K,V>>[] buckets=new LinkedList[SIZE];

    public V put(K key,V value){
        V oldValue=null;
        int index=Math.abs(key.hashCode())%SIZE;
        if (buckets[index]==null)
            buckets[index]=new LinkedList<>();
        LinkedList<MapEntry<K,V>> bucket=buckets[index];
        MapEntry<K,V> pair=new MapEntry<>(key,value);
        boolean found=false;
        ListIterator<MapEntry<K,V>> it=bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair=it.next();
            if (iPair.getKey().equals(key)){
                oldValue=iPair.getValue();
                it.set(pair);
                found=true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key){
        int index=Math.abs(key.hashCode())%SIZE;
        if (buckets[index]==null)return null;
        for (MapEntry<K,V> iPair:buckets[index]) {
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set=new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket==null)continue;
            for (MapEntry<K,V> mpair:bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
