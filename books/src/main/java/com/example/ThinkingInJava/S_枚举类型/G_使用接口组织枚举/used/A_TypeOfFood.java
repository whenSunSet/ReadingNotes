package com.example.ThinkingInJava.S_枚举类型.G_使用接口组织枚举.used;


import com.example.ThinkingInJava.S_枚举类型.G_使用接口组织枚举.Food;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 如果想将一个enum分组但是其还有共同点，可以分为不同的enum然后实现同一接口。
* */
public class A_TypeOfFood {
    public static void main(String[] args) {
        Food food= Food.Appetizer.SALAD;
        food= Food.MainCourse.LASAGNE;
        food= Food.Dessert.GELATO;
        food=Food.Coffee.CAPPUCCINO;
    }
}
