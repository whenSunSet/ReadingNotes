package com.example.ThinkingInJava.S_枚举类型.B_向enum中添加新方法;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 1.enum只允许在类中定义实例，之后就不能使用其构造函数了
* 2.构造函数中的参数，就是定义实例时使用的
*
* */
public enum OzWitch {
    WEST("WEST"),
    NORTH("NORTH"),
    EAST("EAST"),
    SOUTH("SOUTH");


    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch:OzWitch.values())
            System.out.println((ozWitch + ": " + ozWitch.getDescription()));
    }
}
