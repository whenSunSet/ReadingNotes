package com.example.ThinkingInJava.S_枚举类型.A_基本enum特性;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 1.ordinal返回enum实例定义的顺序
* 2.每个定义特殊的enum是ENUM类的子类
* 3.Enum类实现了Comparable和Serializable接口
* */
public class EnumClass {
    enum Shrubbery{GROUND,CRAWLING,HANGING}

    public static void main(String[] args) {
        for (Shrubbery shrubbery:Shrubbery.values()){
            System.out.println((shrubbery + "ordinal: " + shrubbery.ordinal()));
            System.out.println((shrubbery.compareTo(Shrubbery.CRAWLING) + " "));
            System.out.println((shrubbery.equals(Shrubbery.CRAWLING) + " "));
            System.out.println((shrubbery == Shrubbery.CRAWLING));
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
            System.out.println("----------------------");
        }
        for (String s:"HANGING CRAWLING GROUND".split(" ")){
            Shrubbery shrubbery=Enum.valueOf(Shrubbery.class,s);
            System.out.println(shrubbery);
        }
    }
}
