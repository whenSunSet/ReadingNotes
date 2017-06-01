package com.example.EffectiveJava.E_泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/5/28.
 */
public class A_不要在新代码中使用原生态类型 {
    /**
     * 1.每个泛型都定义了一 个原生态类型 ，即不带任何实际泛型参数的泛型，List<E>的原生态类型就是List
     * 2.在没有泛型之前，所有的集合内都是一个Object的数组，所以经常会出现将狗插入猫的列表的情况，而且还能运行很久。
     * 3.泛型的好处就是编译器帮你自动处理类型转换，而且如果出现狗插入猫的列表的时候，会在编译的时候就进行提示
     * 4.List和List<Object>的区别在于：前者没有泛型检测，后者在检测的时候表明任何对象都能放入其中。
     * 另一个区别就是List=List<String>成立，List<Object>=List<String>会报错，所以如果使用List，那么就可能会出现把猫转化成狗的情况,而使用List<Object>在编译时就会报错
     * 5.如果你对List中的元素毫不在乎，只是想使用他内部的元素的话，可以使用List<?>
     * 这里可以达到和List相同的效果，但是并不能向其内部插入任何元素，也就杜绝了把狗插入到猫列表的情况
     * 6.由于在运行时泛型会擦除，所以在使用instanceof的时候 使用泛型参数是多余的，所以在使用了instanceof之后需要将原生态类型转化成<?>，以避免狗插入猫列表的情况
     */

    public static void main(String[] args) {
        //1
        List<String> list1=new ArrayList<>();
        List list2=new ArrayList<>();//原生态类型

        //2 list3规定为String的列表
        List list3=new ArrayList<>();
        list3.add("11");
        list3.add("22");
        //但是我可以插入Integer
        list3.add(1);
        //在用的时候，会手动转化为String，但是此时在运行的时候就会出现错误
        for (Object s:list3) {
//            System.out.println(((String) s));
        }

        //3
        List<String> list4=new ArrayList<>();
        list4.add("11");
        list4.add("22");
        //此时插入Integer，就会在编译的时候报错
//        list4.add(1);

        //4
        List list5=new ArrayList<>();
        List<Object> list6=new ArrayList<>();
        List<String> list7=new ArrayList<>();
        list5=list7;
        //list7是String的列表，但是转化成原生态类型之后，被插入了Integer
        list5.add(111);
        //我们在使用List<String>就会在运行时报错
        for (String s:list7){
            System.out.println(s);
        }
        //将List<String>给List<Object>会报错
//        list6=list7;

        //5
        List<?> list8=new ArrayList<>();
        List<String> list9=new ArrayList<>();
        //用了 ？ 之后可以将List<String>给List<?>,但是为了避免插入错误，此时就不能进程插入操作了
        list8=list9;
        //除了null以外的参数插入都会报错
//        list8.add("");
//        list8.add(11);
        list8.add(null);

        //6
        List<?> list10=new ArrayList<>();
        List<String> list11=new ArrayList<>();

        if (list11 instanceof List){
            list10=(List<?>)list11;
        }
        //在instanceof上使用泛型参数是会报错的，因为没用
//        if (list11 instanceof List<String>){
//            list10=(List<?>)list11;
//        }
    }
}
