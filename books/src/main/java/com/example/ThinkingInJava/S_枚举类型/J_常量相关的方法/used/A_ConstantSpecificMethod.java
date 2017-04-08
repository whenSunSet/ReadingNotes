package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法.used;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 与常量类型不同的是我们可以让每个实例实现不同的方法，类似于每个实例都是一个不同的类，然后可以体现出多态，不过也仅仅是类似而已。
* */
public enum A_ConstantSpecificMethod {
    DATE_TIME{
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },CLASSPATH{
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },VERSION{
        String getInfo() {
            return System.getProperty("java version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (A_ConstantSpecificMethod constantSpecificMethod1 :values())
            System.out.println(constantSpecificMethod1.getInfo());
    }
}
