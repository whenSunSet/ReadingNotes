package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
/*
* 在非泛型代码中，参数类型不能随着子类型的变化而变化，但是这里可以。
* */
public class GenericsAndReturnTypes_ten {
    interface GenericGetter<T extends GenericGetter<T>>{
        T get();
    }
    interface Getter extends GenericGetter<Getter>{}

    void test(Getter getter){
        Getter result= getter.get();
        GenericGetter genericGetter= getter.get();
    }
}
