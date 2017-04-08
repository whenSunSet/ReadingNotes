package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

import com.example.Q_容器深入研究.D_理解Map.MapEntry;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 下面我们自己创建了一个map，我们不用继承完整的Map，可以继承AbstractMap，
* 其他容器也有这样的抽象类方便开发者继承。
*
* 这里要注意的一个问题就是get()方法中的参数不能是K，这是由于早期兼容泛型的原因造成的。
* */
public class E_SlowMap<K,V> extends AbstractMap<K,V>{
    private List<K> keys=new ArrayList<>();
    private List<V> values=new ArrayList<>();

    public V put(K key,V value){
        V oldValue=get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    public V get(Object key){
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set=new HashSet<>();
        Iterator<K> ki=keys.iterator();
        Iterator<V> vi=values.iterator();

        while (ki.hasNext()){
            set.add(new MapEntry<>(ki.next(),vi.next()));
            return set;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
