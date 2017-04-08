package com.example.ThinkingInJava.P_数组.C_Arrays实用功能;

import java.util.Arrays;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 由这个练习可以证明数组的比较就是将每个数组对应的item用equals进行比较
* */
public class Test {
    private int a;

    public Test(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        Test test=(Test)obj;
        return test.getA()==this.getA();
    }

    public static void main(String[] args) {
        Test[] tests={new Test(1),new Test(2),new Test(3),new Test(4)};
        Test[] tests1={new Test(1),new Test(2),new Test(3),new Test(4)};

        System.out.println(Arrays.equals(tests, tests1));
    }
}
