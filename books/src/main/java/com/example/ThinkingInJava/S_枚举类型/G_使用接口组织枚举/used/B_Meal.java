package com.example.ThinkingInJava.S_枚举类型.G_使用接口组织枚举.used;

import com.example.S_枚举类型.G_使用接口组织枚举.Course;
import com.example.S_枚举类型.G_使用接口组织枚举.Food;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 我们可以通过传入枚举类型的Class为构造参数，来构造枚举的枚举，就类似于分类下的分类。
* 枚举类是Object的子类
* 看到这里我们可以看见，枚举其实就是类类型最终的字节码就是class形式的，然后其很多特性都是编译器自动赋予的。
* 1.静态类型，也就是说只能在类的内部定义实例，除此之外都不行。
* 2.自动实现了排序
* 3.能够通过Class，或者某个类方法，直接获取所有实例
* 4.可以直接用于switch
* 5.Enum类实现了Comparable和Serializable接口
* */
public class B_Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course c : Course.values()) {
                Food food = c.randomSelection();
                System.out.println(food);
                Object o=(Object)food;
                System.out.println(o);
            }
            System.out.println("---");
        }
    }
}
