package com.example.ThinkingInJava.T_注解.A_基本语法;

/**
 * Created by heshixiyang on 2017/2/3.
 */
public class Testable {
    public void execute(){
        System.out.println("Executing");
    }
    @A_Test
    void textExecute(){ execute();}
}
