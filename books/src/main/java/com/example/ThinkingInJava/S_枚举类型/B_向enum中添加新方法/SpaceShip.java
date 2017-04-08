package com.example.ThinkingInJava.S_枚举类型.B_向enum中添加新方法;

/**
 * Created by heshixiyang on 2017/1/23.
 */
/*
* 覆盖实例的方法
* */
public enum  SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id=name();
        String lower=id.substring(1).toLowerCase();
        return id.charAt(0)+lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s:SpaceShip.values())
            System.out.println(s);
    }
}
