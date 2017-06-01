package com.example.EffectiveJava.E_泛型;

/**
 * Created by heshixiyang on 2017/5/28.
 */
public class B_消除非受检警告 {
    /**
     * 1.首先需要尽可能消除所有的关于泛型的警告，以保证自己的代码是类型安全的
     * 2.如果实在有一些消除不了，那么在确保类型转换正确的情况下，可以使用@SuppressWarnings("unchecked")来禁止警告
     * 3.在每条@SuppressWarnings("unchecked")旁都需要加条注释告诉使用者为什么是正确的
     */
}
