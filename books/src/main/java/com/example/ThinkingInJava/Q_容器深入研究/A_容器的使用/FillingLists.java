package com.example.ThinkingInJava.Q_容器深入研究.A_容器的使用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class FillingLists {

    static class StringAddress{
        private String s;

        public StringAddress(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return super.toString()+" "+s;
        }
    }
    /*
    * 两种自动填充容器的方式：
    * 1.方法一所有引用都指向的是同一个对象
    * 2.方法二和方法一样，并且只能替换list中已经存在的元素，不能添加新元素。
    * */
    public static void main(String[] args) {
        List<StringAddress> list=new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);

        Collections.fill(list,new StringAddress("World"));
        System.out.println(list);

    }

}

