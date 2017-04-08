package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

import com.example.Q_容器深入研究.D_理解Map.Gorundhog2;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 我们通过继承Groundhog来重写hashCode将散列数变成我们自己定义的标识符，然后通过equals方法将两个标识符进行比较。
* 就能创建出有用的HashMap的键。
* */
public class C_SpringDetector {
    public static void main(String[] args) throws Exception {
        B_SpringDetector.detectSpring(Gorundhog2.class);
    }
}
