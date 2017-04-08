package com.example.ThinkingInJava.S_枚举类型.G_使用接口组织枚举;

import com.example.S_枚举类型.F_随机选取.Enums;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public enum Course {
    Appetizer(Food.Appetizer.class),
    MainCourse(Food.MainCourse.class),
    Dessert(Food.Dessert.class),
    Coffee(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values=kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
