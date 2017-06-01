package com.example.EffectiveJava.B_创建和销毁对象;

import java.io.Serializable;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class C_用私有构造器或者枚举类型强化Singleton属性 {
    /**
     * 1.使用A中的静态工厂方法，将Singleton和构造函数设置成private
     * 2.因为通过反射可以使用private的构造方法，所以可以在创建第二个实例的时候抛出异常
     * 3.在序列化的时候必须声明类中所有域都是transient和提供一个readResolve方法，否则每次反序列化都会创建一个新实例
     * 4.可以使用枚举来创建单例，这时候2、3的麻烦都会消失
     */

    // 1
    static class Elvis{
        private static final Elvis singleton=new Elvis();
        private Elvis(){}
        public static Elvis getSingleton(){
            return singleton;
        }
    }

    // 2
    static class Elvis2{
        private static final Elvis2 singleton=new Elvis2();

        private static boolean isFirstCreate=true;
        private Elvis2()  {
            if (!isFirstCreate){
                throw new AssertionError();
            }
            isFirstCreate=false;
        }
        public static Elvis2 getSingleton(){
            return singleton;
        }
    }

    // 3
    static class Elvis3 implements Serializable{
        private static Elvis3 singleton =new Elvis3();
        private transient int a=0;
        private static boolean isFirstCreate=true;
        private Elvis3() {
            if (!isFirstCreate){
                throw new AssertionError();
            }
            isFirstCreate=false;
        }
        public static Elvis3 getSingleton(){
            return singleton;
        }

        private Object readResolve(){
            return singleton;
        }
    }

    // 4
    enum Elvis4{
        SINGLETON;
    }
}
