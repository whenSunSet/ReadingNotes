package com.example.ThinkingInJava.Q_容器深入研究.B_Set和储存顺序;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class TypeForSets {

    static class SetType{
        int i;

        public SetType(int i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof SetType &&(i==((SetType)obj).i);
        }

        @Override
        public String toString() {
            return String.valueOf(i);
        }
    }

    static class HashType extends SetType{

        public HashType(int i) {
            super(i);
        }

        @Override
        public int hashCode() {
            return i;
        }
    }

    static class TreeType extends SetType implements Comparable<TreeType>{
        public TreeType(int i) {
            super(i);
        }

        @Override
        public int compareTo(TreeType o) {
            return (o.i<i?-1:(o.i==i?0:1));
        }
    }

    static <T> Set<T> fill(Set<T> set,Class<T> type){
        for (int i = 0; i < 10; i++) {
            try {
                set.add(type.getConstructor(int.class).newInstance(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
//        fill(set,type);
//        fill(set,type);
        System.out.println(set);
    }

    /*
    * 1.Set中储存的类型必须有equals方法
    * 2.HashSet和LinkedHashSet储存的类型中必须有hashCode方法
    * 3.TreeSet储存的类型必须实现comparable接口，否则会报错
    * 4.HashSet根据hashCode以某种方式保存元素
    * 5.LinkedHashSet根据插入的顺序保存元素
    * 6.TreeSet根据排序顺序保存元素
    * 7.对于没有重新实现hashCode类型如SetType和TreeType将她们放入Hash的Set中会产生重复，并且难以被发现
    * */
    public static void main(String[] args) {
        test(new HashSet<>(),HashType.class);
        test(new LinkedHashSet<>(),HashType.class);
        test(new TreeSet<>(),TreeType.class);

        test(new HashSet<>(),SetType.class);
        test(new HashSet<>(),TreeType.class);
        test(new LinkedHashSet<>(),SetType.class);
        test(new LinkedHashSet<>(),TreeType.class);

        try {
            test(new TreeSet<>(),SetType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            test(new TreeSet<>(),HashType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
