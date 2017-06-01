package com.example.EffectiveJava.B_创建和销毁对象;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class F_消除过期的对象引用 {
    /**
     * 1.一些对象在没有用了之后，还被有用的对象持有引用，此时就产生了内存泄漏
     * 2.为了解决1，需要在最紧凑的作用域中定义每一个类型，而不是自己每次都手动去清理不需要的对象。
     * 3.对于自己管理内存的类，最需要注意内存泄漏问题，因为垃圾回收器并不知道类中那些对象是失效的，这里需要程序员其告知垃圾回收器
     * 4.缓存可能会内存泄漏：1.当外部没有缓存的引用项的时候，某些情况下这个缓存就可以当成没用的了，所以可以使用WeakHashMap来让垃圾回收器自动清理缓存。
     *                       2.更多的情况是，虽然这个缓存没有引用项了，但是其在未来可能会有用，此时可以使用LRU算法来清理缓存
     * 5.监听器和回调可能会内存泄漏：有时候一个回调被注册了，但是使用了以后没有被取消注册，此时回调就会被堆积起来，解决方法就是WeakHashMap
     */

    // 1、2、3
    static class Stack{
        private Object[] elements;
        private int size=0;
        private static final int DEFAULT_INITIAL_CAPACITY=16;

        public Stack() {
            elements=new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object o){
            ensureCapacity();
            elements[size++]=o;
        }

        public Object pop(){
            //当一个对象被pop了，那么这个对象就没有用了，被称为过期，但是其引用还保存在Stack中，此时就产生了内存泄漏
//            if (size==0)
//                throw new EmptyStackException();
//            return elements[--size];
            //需要将要pop的对象置为null，这样就相当于告诉了垃圾回收器，这个对象没用了，你可以去回收了
            if (size==0)
                throw new EmptyStackException();
            Object object=elements[--size];
            elements[size]=null;
            return object;
        }

        private void ensureCapacity(){
            if (elements.length==size){
                elements= Arrays.copyOf(elements,2*size+1);
            }
        }
    }
}
