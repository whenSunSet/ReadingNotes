package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 分析了编译器生成的代码我们可以发现，这里每个enum元素都是LikeClasses类型的static final实例
* 所以其内部方法无法访问外部非static的元素或者方法
* */
public class NotClasses {
//    void f1(LikeClasses.WINKEN winken){}
}
