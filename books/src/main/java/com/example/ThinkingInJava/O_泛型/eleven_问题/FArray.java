package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class FArray {
    public static <T> T[] fill(T[] a, Generator<T> generator){
        for (int i = 0; i < a.length; i++) {
            a[i]=generator.next();
        }
        return a;
    }

    public static class Generator<T>{
        private T item;

        public Generator(T item) {
            this.item = item;
        }

        public T next(){
            return item;
        }
    }
}
