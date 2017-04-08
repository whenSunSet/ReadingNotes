package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;


import com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.Groundhog3;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 这里是我自己的实验，我测试了是否HashMap的比较只需要equals方法，结论是否定的。
* HashMap的比较是由hashCode和equals共同作用。
* */
public class D_SpringDetector {
    public static void main(String[] args) throws Exception {
        B_SpringDetector.detectSpring(Groundhog3.class);
    }
}
