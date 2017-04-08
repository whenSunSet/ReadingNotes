package com.example.ThinkingInJava.O_泛型.ten_通配符.first;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 这里我们将apple数组向上转型为fruit数组，在运行时fruits内部的类信息还是apple。
* 所以我们只能在fruits中放置apple实例，当我们放置fruit的子类却不是apple的时候，就相当于向下转型了
* 所以会报错。这个问题在编译器不会出现，但是会报运行时错误，我们可以通过泛型来在编译期就检测出这个错误。
* */
public class CovariantArrays_one {
    public static void main(String[] args) {
        Fruit[] fruits=new Apple[10];
        fruits[0]=new Apple();
        fruits[1]=new Jonathan();
        try {
            fruits[0]=new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0]=new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
