package com.example.ThinkingInJava.T_注解.B_编写注释处理器.used;


import com.example.ThinkingInJava.T_注解.B_编写注释处理器.Constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 我们这里用了嵌套注解的功能，将之前定义的字段约束注解也添加了进来
* 这里constraints()的默认值就是@Constraints中所有都是默认值的@Constraints
* 如果想让某个值不为默认可以这样Constraints constraintsTest() default @Constraints(unique = true);
* */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface B_SQLString {
    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;

}
