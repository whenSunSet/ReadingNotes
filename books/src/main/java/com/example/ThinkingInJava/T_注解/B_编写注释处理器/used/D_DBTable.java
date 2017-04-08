package com.example.ThinkingInJava.T_注解.B_编写注释处理器.used;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 使用@Target可以用逗号分割，使其兼容多个类型
* */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface D_DBTable {
    public String name() default "";
}
