package com.example.ThinkingInJava.Q_容器深入研究.C_队列;

import com.example.ThinkingInJava.O_泛型.eleven_问题.FArray;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 除了优先级队列以外，其他Queue都是按照被置于Queue的顺序排列的
* */
public class QueueBehavior {
    private static  int count=8;
    static <T> void test(Queue<T> queue, FArray.Generator<T> generator){
        for (int i = 0; i < count; i++) {
            queue.offer(generator.next());
        }
        while (queue.peek()!=null)
            System.out.print((queue.remove() + " "));
        System.out.println();
    }

    static class Gen extends FArray.Generator<String>{
        String[] strings="One Two Three Four Five Six Seven Eight".split(" ");
        int i=0;

        @Override
        public String next() {
            return strings[i++];
        }

        public Gen(String item) {
            super(item);
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(),new Gen(""));
        test(new PriorityQueue<>(),new Gen(""));
        test(new ArrayBlockingQueue<>(count),new Gen(""));
        test(new ConcurrentLinkedQueue<>(),new Gen(""));
        test(new LinkedBlockingDeque<>(),new Gen(""));
        test(new PriorityBlockingQueue<>(),new Gen(""));
    }
}
