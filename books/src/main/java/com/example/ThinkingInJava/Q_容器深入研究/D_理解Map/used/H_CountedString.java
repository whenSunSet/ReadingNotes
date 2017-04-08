package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 对于一个好的hashCode的编写，有以下几个步骤：
* 1.定义一个变量result（任意值）
* 2.对于类中每一个要在equals中比较的字段都获取一个c
* 3.每获取一个c之后都进行result=37*result+c
* 4.返回一个result
*
* 对于不同的字段c的获取方式：
* 1.boolean：f?0:1
* 2.byte char short int:(int)f
* 3.long:(int)(f^(f>>>32))
* 4.float:Float.floatToIntBits(f)
* 5.double:Double.doubleToLongBits(f)
* 6.Object:hashCode()
* 7.数组：每一个元素获取上述的c
* */
public class H_CountedString {
    private static List<String> created=new ArrayList<>();
    private String s;
    private int id=0;

    public H_CountedString(String str) {

        this.s = str;
        created.add(s);
        created.stream().filter(s1 -> s1.equals(s)).forEach(s1 -> id++);
    }

    @Override
    public String toString() {
        return "String: "+s+" id: "+id+" hashCode: "+hashCode()+"\n";
    }

    @Override
    public int hashCode() {
        int result=17;
        result=37*result+s.hashCode();
        result=37*result+id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof H_CountedString &&
                s.equals(((H_CountedString)obj).s)&&
                id==((H_CountedString)obj).id;
    }

    public static void main(String[] args) {
        Map<H_CountedString,Integer> map= new HashMap<>();
        H_CountedString[] countedStrings=new H_CountedString[5];
        for (int i = 0; i < countedStrings.length; i++) {
            countedStrings[i]=new H_CountedString("hi");
            map.put(countedStrings[i],i);
        }
        System.out.println(map);
        for (H_CountedString s : countedStrings) {
            System.out.println(s);
            System.out.println(map.get(s));
        }
    }
}
