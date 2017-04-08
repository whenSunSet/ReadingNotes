package com.example.ThinkingInJava.O_泛型.nine_边界.second;

import com.example.O_泛型.nine_边界.Bounded;

/**
 * Created by heshixiyang on 2017/1/16.
 */

/*
* 这个在first的基础上将可被继承的冗余代码去掉了。
* 虽然对每个层次的方法进行了复用，但是子类泛型中的extends不能继承于父类，这里需要将父类中所有的泛型extends全部列出，否则会报错。
* */
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid=new Solid2<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
