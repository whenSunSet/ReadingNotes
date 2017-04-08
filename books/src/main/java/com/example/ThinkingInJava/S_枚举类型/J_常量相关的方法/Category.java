package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法;

import java.util.EnumMap;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public enum  Category {
    MONEY(Input.NICKEL,Input.DIME,Input.QUARTER,Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE,Input.CHIPS,Input.SOAP,Input.SODA),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);
    private Input[] values;

    Category(Input... types) {
        values=types;
    }
    private static EnumMap<Input,Category> categoryEnumMap=new EnumMap<Input, Category>(Input.class);
    static {
        for (Category category:Category.class.getEnumConstants())
            for (Input type:category.values)
                categoryEnumMap.put(type,category);
    }
    public static Category categorize(Input input){
        return categoryEnumMap.get(input);
    }
}
