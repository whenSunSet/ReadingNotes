package com.example.ThinkingInJava.P_数组.B_数组与泛型;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class ParameterizedArrayType {
    interface F<T> {
        void f();
    }
    static class A<T> implements F<T>{
        T item;

        public A(T item) {
            this.item = item;
        }

        @Override
        public void f() {
            System.out.println(item.getClass().getSimpleName());
        }
    }


    static class ClassParameter<T>{
        public T[] f(T[] arg){
//            arg=new T[];
            return arg;
        }
    }

    static class MethodParameter{
        public static <T>  T[] f(T[] arg){
            return arg;
        }
    }

    /*
    * 1.可以参数化数组本身:T[]
    * 2.可以实例化具有参数化类型的数组:static A_java基础<Apple>[] as=new A_java基础[1];
    * 3.不能实例化泛型数组:T[] ts=new T[];
    * */
    public static void main(String[] args) {
        Integer[] integers={1,2,3,4,5};
        Double[] doubles={1.1,2.2,3.3,4.4,5.5};

        Integer[] integers1=new ClassParameter<Integer>().f(integers);
        Double[] doubles1=new ClassParameter<Double>().f(doubles);
        integers1=MethodParameter.f(integers);
        doubles1=MethodParameter.f(doubles);

    }

}
