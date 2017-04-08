package com.example.ThinkingInJava.O_泛型.eleven_问题;


/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 子类覆盖了基类的方法，并返回了子类类型，这在1.5之前的版本是不行的。
* */
public class CovariantReturnTypes_nine {
    class Base{}
    class Derived extends Base{}
    interface OrdinaryGetter{
        Base get();
    }

    interface DerivedGetter extends OrdinaryGetter{
        Derived get();
    }

    void test(DerivedGetter derivedGetter){
        Derived derived=derivedGetter.get();
    }
}
