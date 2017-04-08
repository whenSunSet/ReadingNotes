package com.example.ThinkingInJava.S_枚举类型.D_values的神秘之处;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 1.ENUM中是没有values()方法的，其子类的方法是编译器插入的static方法
* 2.Enum类是final的所以无法自行继承它
* 3.由于擦除我们无法获取Enum的完整信息，其实这里的Enum是Enum<Explore>
* 4.我们还可以用该Enum的class中的getEnumConstants()
* */
public class Reflection {
    enum Explore{HERE,THERE}

    public static Set<String> analyze(Class<?> enumClass){
        System.out.println(("------------ Analyzing " + enumClass + "-----------------"));
        System.out.println("Interfaces");
        for (Type type:enumClass.getGenericInterfaces())
            System.out.println(type);
        System.out.println(("Base: " + enumClass.getSuperclass()));
        System.out.println("Methods: ");
        Set<String> methods=new TreeSet<>();
        for (Method method:enumClass.getMethods())
            methods.add(method.getName());
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {

        Set<String> exploreMethods=analyze(Explore.class);
        Set<String> enumMethods=analyze(Enum.class);
        System.out.println(("Explore.containsAll(Enum)?" + exploreMethods.containsAll(enumMethods)));
        System.out.println(("Explore.removeAll(Enum) " + exploreMethods.removeAll(enumMethods)));
        System.out.println(exploreMethods);
    }
}
