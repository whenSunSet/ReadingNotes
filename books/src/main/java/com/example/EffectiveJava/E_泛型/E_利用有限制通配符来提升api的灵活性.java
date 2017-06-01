package com.example.EffectiveJava.E_泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/5/28.
 */
public class E_利用有限制通配符来提升api的灵活性 {
    /**
     * 1.参数化类型是不可变的，List<String>不是List<Object>的子类型，我们不能将List<Object>=List<String>，即不能使List<String>向上转型为List<Object>。
     * 2.为了让List<String>可以向上转化，可以将List<Object>替换为List<？extends Object>，这里表示List中可以放一切继承于Object的对象，
     * 也就是说List<？extends Object>是List<String>的基类，这样一来就可以有List<？extends Object>=List<String>。
     * 3.但是2中就出现了一个问题：我们在使用List<？extends Object>的插入方法的时候，并不知道究竟应该放入什么类型的对象，因为使用这个对象的时候String的类型信息已经被擦除了。
     * 所以为了不让把狗插入猫列表的情况出现。List<？extends Object>禁止插入任何对象。而获取其中的对象都是Object类型。
     * 4.有了2，那么我们如何让List<String>向下转型呢？这时候要引入List<？super String>，这里表示，这个List里面可以放所有为String父类的对象，此时就可以有List<？super String>=List<String>。
     * 5.4中也会有问题，当我们获取List<？super String>中的数据的时候，由于里面放的全是String父类的对象，所以这里所有的返回都是Object。
     * 而插入的时候因为每个空都能容纳String父类的对象，所以这个List最少也能插入String和其子类的对象。
     *
     * 总结一下：PECS，extends善于提供精确的对象，Super善于插入精确的对象
     */
    public static void main(String[] args) {
        List<Number> numberList=new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        List<? extends Number> numberArrayList=new ArrayList<>();
        List<? super Number> numberArrayList1=new ArrayList<>();

        numberArrayList=integerList;
//        numberArrayList.add(1);
//        numberArrayList.add(new Object());
//        Integer integer=numberArrayList.get(0);
        Number number=numberArrayList.get(0);

        numberArrayList1=numberList;
//        numberArrayList1=integerList;
        numberArrayList1.add(new Integer(1));
        numberArrayList1.add(new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        });

//        Integer integer=numberArrayList1.get(0);
//        Number number1=numberArrayList1.get(0);
        Object o =numberArrayList1.get(0);
    }
}
