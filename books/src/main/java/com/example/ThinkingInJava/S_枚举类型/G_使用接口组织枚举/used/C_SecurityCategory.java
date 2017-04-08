package com.example.ThinkingInJava.S_枚举类型.G_使用接口组织枚举.used;


import com.example.ThinkingInJava.S_枚举类型.F_随机选取.Enums;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 我们可以直接将接口放在Enum里面进行嵌套，Security可以将需要嵌套的多种Enum组合成公共类，方便SecurityCategory_3进行组织
* */
public enum C_SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);
    Security[] values;
    interface Security{
        enum Stock implements Security{SHORT,LONG,MARGIN}
        enum Bond implements Security{MUNICIPAL,JUNK}
    }

    private C_SecurityCategory(Class<? extends Security> kind) {
        values=kind.getEnumConstants();
    }
    public Security randomSelection(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            C_SecurityCategory category=Enums.random(C_SecurityCategory.class);
            System.out.println((category + ": " + category.randomSelection()));
        }
    }
}
