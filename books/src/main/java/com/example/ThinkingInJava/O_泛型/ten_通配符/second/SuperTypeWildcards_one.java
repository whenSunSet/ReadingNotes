package com.example.ThinkingInJava.O_泛型.ten_通配符.second;

import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Apple;
import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Fruit;
import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 我们可以把一个引用当成一个盘子:
* 1.首先我们有一个水果盘子(List<Fruit> fruits),我们可以在里面放各种水果。
* 2.然后我们希望可以把苹果盘子里的东西倒给水果盘子，可是一般的方法不行。
* 3.这时候我们用? extends Fruit这个表示了可以放一切水果的盘子，当然也表示水果盘子。
* 4.但是这种办法有个问题就是，我们将(某个种类的盘子水果)倒给(可以放一切水果的盘子)之后，这个盘子会忘记里面到底放了什么水果，
* 所以为了解决这个问题，这个盘子就拒绝我们再往里面覆盖或者增加水果。
* 5.当然我们还是可以从里面取出水果的，因为盘子忘记具体是什么水果，所以只会告诉我们它是一个水果。
*
* 6.现在我们又希望，我们的可以把物体盘子里的东西倒给水果盘子,当然一般的方法也是不行的。
* 7.所以就有了? super Fruit，这是一个能放任何是水果的爸爸物体的盘子。
* 8.这里也有一个问题：盘子里放的东西种类太多，盘子记不住具体是水果的哪个爸爸，所以一视同仁，把取出来的东西都称为水果祖宗object。
* 9.由于这里面可以放任何水果爸爸,孔比较大，有些苹果和橘子也过来凑热闹，所以她们也能被放进去，
* 但是能进去的只有水果的儿子，所以我们在取出的时候，可以直接转型为水果。
*
* 10.有个PECS原则：频繁读取用Extends，经常插入用Super。
* */
public class SuperTypeWildcards_one {
    static void writeTo(){
        List<Fruit> fruits=new ArrayList<>();
        fruits.add(new Fruit());
        fruits.add(new Apple());
        System.out.println(fruits.get(0));
        System.out.println(fruits.get(1));

//        fruits=new ArrayList<Apple>();
        List<Apple> apples= Arrays.asList(new Apple());
        List<? extends Fruit> apples4=apples;
//        apples4.add(new Fruit());
        Fruit fruit=apples4.get(0);
//        Apple apple=apples4.get(0);
        System.out.println(apples4.get(0));

//        fruits=new ArrayList<Object>();
        List<Object> list=new ArrayList<>();
        list.add(new Object());
        List<? super Fruit> objects=list;
//        objects.add(new Object());
        objects.add(new Apple());
        objects.add(new Orange());

//        Apple apple=objects.get(0);
        System.out.println(objects.get(0));
        System.out.println(objects.get(1));
        System.out.println(objects.get(2));
    }

    public static void main(String[] args) {
        writeTo();
    }
}
