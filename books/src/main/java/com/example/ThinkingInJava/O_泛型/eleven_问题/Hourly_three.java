package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 一个类不能实现同一个泛型接口的两种变体，因为泛型擦除会将两个接口变成同样的接口，这就意味着实现了一个接口两次。
* */
//public class Hourly extends Employee implements Payable<Hourly>{
//}
/*
* 练习31：但是如果把两个泛型去掉之后又可以编译了。
* */
class MultipleInterfaceVariants extends Employee implements Payable{

}
