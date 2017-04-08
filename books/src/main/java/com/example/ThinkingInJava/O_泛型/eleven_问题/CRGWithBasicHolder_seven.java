package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 我们可以看见如果基类的泛型中使用了子类作为参数，那么在所有子类中我们可以使用确切类型而不是基类的功能。
* */
public class CRGWithBasicHolder_seven {
    public static class Subtype extends BasicHolder<Subtype>{

    }
    public static void main(String[] args) {
        Subtype subtype=new Subtype(),subtype1=new Subtype();
        subtype.setElement(subtype1);
        Subtype subtype2=subtype.getElement();
        subtype.f();
    }
}
