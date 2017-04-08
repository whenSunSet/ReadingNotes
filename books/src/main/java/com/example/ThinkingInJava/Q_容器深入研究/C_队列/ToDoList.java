package com.example.ThinkingInJava.Q_容器深入研究.C_队列;

import java.util.PriorityQueue;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 可以通过继承优先队列实现自己的队列
* 具体比较优先级在队列的item之中
* */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary>o.primary)
                return 1;
            if (primary==o.primary)
                if (secondary>o.secondary)
                    return 1;
                else if (secondary==o.secondary)
                    return 0;
            return 0;
        }

        @Override
        public String toString() {
            return Character.toString(primary)+secondary+": "+item;
        }
    }

    public boolean add(String td  ,char pri,int sec) {
        return super.add(new ToDoItem(pri,sec,td));
    }

    public static void main(String[] args) {
        ToDoList toDoList=new ToDoList();
        toDoList.add("Empty trash",'C',4);
        toDoList.add("Feed dog",'A',2);
        toDoList.add("Feed Bird",'B',7);
        toDoList.add("Mow lawn",'C',3);
        toDoList.add("Water lawn",'A',1);
        toDoList.add("Feed Cat",'B',1);

        while (!toDoList.isEmpty())
            System.out.println(toDoList.remove());
    }
}
