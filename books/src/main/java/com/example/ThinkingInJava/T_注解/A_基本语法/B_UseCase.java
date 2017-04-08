package com.example.ThinkingInJava.T_注解.A_基本语法;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 在注解中使用的元素只能是以下类型：
* 1.所有基本类型
* 2.String
* 3.Class
* 4.enum
* 5.Annotation
*
* 默认值的限制：
* 1.不能为不确定的值
* 2.不能为null
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface B_UseCase {
    enum A{a,b}
    public int id();
    public String description() default "no description";
    public A getEnum() default A.a;
//    public Target getAnnotation() ;
    public Class getClasss() default C_PasswordUtils.class;
}
