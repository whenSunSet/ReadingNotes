package com.example.ThinkingInJava.T_注解.A_基本语法;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 这里是定义注解的地方，需要在头上赋予一些元注解
* @Target(ElementType.METHOD)表示应用在什么地方：一个字段或者一个方法
* @Retention(RetentionPolicy.RUNTIME)表示在那个级别使用：源代码中、类文件中或者运行时
* 注解中一般会含有某些元素表示默认某些值，我们可以在分析注解的时候利用它们
* 没有元素的注解被称为标记注解
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface A_Test {
}
