package com.example.ThinkingInJava.T_注解.B_编写注释处理器.used;


import com.example.ThinkingInJava.T_注解.A_基本语法.B_UseCase;
import com.example.ThinkingInJava.T_注解.A_基本语法.C_PasswordUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 这里用到了getAnnotation()和getDeclaredMethods()方法，他们属于AnnotatedElement接口，Class、Method、Field都实现了该接口
* 这里我们先获取了所有PasswordUtils的方法，再获取每个方法上UseCase.class这种类型的注解，如果没有的话会返回null。
* 注解使用的主要途径就是通过运行时的反射得到注解类。
*
* */
public class A_UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method method:cl.getDeclaredMethods()){
            B_UseCase useCase2 =method.getAnnotation(B_UseCase.class);
            if (useCase2 !=null)
                System.out.println(("Found Use Case: " + useCase2.id() + " " + useCase2.description()));
            useCases.remove(new Integer(useCase2.id()));
        }
        for (int i:useCases)
            System.out.println(("Missing use case-" + i));
    }

    public static void main(String[] args) {
        List<Integer> u=new ArrayList<>();
        Collections.addAll(u,47,48,49,50);
        trackUseCases(u, C_PasswordUtils.class);
    }
}
