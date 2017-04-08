package com.example.ThinkingInJava.O_泛型.ten_通配符.third;


import com.example.ThinkingInJava.O_泛型.ten_通配符.first.Holder_five;

/**
 * Created by heshixiyang on 2017/1/17.
 */
public class Wildcards_three {
    static void rawArgs(Holder_five holder_five, Object arg){
        holder_five.setValue(arg);
        holder_five.setValue(new Wildcards_three());

//        T t=holder_five.getValue();
        Object o=holder_five.getValue();
    }
    static void unboundedArg(Holder_five<?> holder_five,Object arg){
//        holder_five.setValue(arg);
//        holder_five.setValue(new Wildcards_three());

//        T t=holder_five.getValue();
        Object o=holder_five.getValue();
    }

    static <T> T exact1(Holder_five<T> holder_five){
        T t=holder_five.getValue();
        return t;
    }

    static <T> T exact2(Holder_five<T> holder_five,T arg){
        holder_five.setValue(arg);
        T t=holder_five.getValue();
        return t;
    }

    static <T> T wildSubtype(Holder_five<? extends T> holder_five,T arg){
//        holder_five.setValue(arg);
        T t=holder_five.getValue();
        return t;
    }

    static <T> void wildSpuertype(Holder_five<? super T> holder_five,T arg){
//        T t=holder_five.getValue();
        holder_five.setValue(arg);
        Object o=holder_five.getValue();
    }

    public static void main(String[] args) {
        Holder_five raw=new Holder_five<Long>();
        raw=new Holder_five();
        Holder_five<Long> qualified=new Holder_five<>();
        Holder_five<?> unbounded=new Holder_five<>();
        Holder_five<? extends Long> bounded=new Holder_five<>();
        Long lng=1L;
        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);

        unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded,lng);
        unboundedArg(bounded,lng);
    }

}
