package com.example.EffectiveJava.B_创建和销毁对象;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class D_通过私有构造器强化不可实例化的能力 {
    /**
     * 1.一些工具类不希望被实例化，而编译器会自动给类提供一个无参构造函数，所以我们可以提供private的构造函数，并且为了防止反射，在里面抛出异常。
     */
    // 1
    static class UtilityClass{
        private UtilityClass(){
            throw new AssertionError();
        }
    }
}
