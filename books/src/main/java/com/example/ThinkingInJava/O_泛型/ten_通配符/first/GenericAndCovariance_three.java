package com.example.ThinkingInJava.O_泛型.ten_通配符.first;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/1/17.
 */
/*
* 这里引入了一个术语，协变性：如果Base类是Sub类的基类，那么Base列表类就是是Sub列表类的基类。这里的列表包括了数组和容器。
* 在这里我们可以总结出：1.数组是支持协变性的这是由于其在运行时会对数组内部的数据进行检查。
* 2.而容器的泛型是不支持协变性的这是因为在运行时泛型会被擦除，如果不在编译时对其进行约束的话，那么就会出现猫列表插入狗的现象。
*
* 这里之后java通过通配符的形式支持了容器的协变性：下面的代码可以读作：fruits是一个具有任何从fruit中继承来的类的列表。
* 但是这里有个问题就是，fruits中放的并不是任意从fruit中继承来的类，而是一个明确的类型。然而这个类型被向上转型了，所以其具体类型是没人关心的。
* 此时一个大问题就来了：如果这个fruits唯一的限制就是其持有某种具体的fruit类型或子类型，而其具体的类型又是不可知的，那么我们要怎么来安全的向这个list中插入元素呢？
* 所以这里又绕到上面的问题了，需要运行时候检测。
*
* 综上所述：对于列表协变性，只有数组能完全做到。容器目前只能做到取出的协变性，无法做到插入协变性，具体表现在fruits无法进行任何元素的插入甚至是Object。
* */
public class GenericAndCovariance_three {
    public static void main(String[] args) {
        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Jonathan());
        List<? extends Fruit> fruits=apples;
        List<Apple> apples1=apples;

        System.out.println(fruits.get(0));

//        fruits.add(new Apple());
//        fruits.add(new Fruit());
//        fruits.add(new Orange());
//        fruits.add(new Jonathan());

        Number[] numbers=new Integer[10];
        numbers[0]=1;
        numbers[1]=1.1f;

//        List<Number> numberList=new ArrayList<Integer>();
    }
}
