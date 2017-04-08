package com.example.ThinkingInJava.O_泛型.ten_通配符.first;

/**
 * Created by heshixiyang on 2017/1/17.
 */
public class Holder_five<T> {
    private T value;

    public Holder_five() {
    }

    public Holder_five(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /*
    * 这里的例子创建了一个和之前List一样的环境，我们可以确定当使用了? extends Fruit，此时后面的引用都是基于该泛型来判断方法的参数。
    * 此时没有参数能够匹配这个类型，所以就造成了setValue无法放入任何类型。
    * 但是我们在使用构造函数的时候却能够放入Apple，这是因为在这里我们编译器知道了足够的信息。
    * 此外没有使用泛型参数的函数，都能良好的工作。
    * */
    public static void main(String[] args) {
        Holder_five<Apple> holderFive =new Holder_five<>(new Apple());
        Apple d= holderFive.getValue();
        holderFive.setValue(d);
//        Holder_five<Fruit> fruitHolder=holderFive;
        Holder_five<? extends Fruit> holderFive1 = holderFive;
        Holder_five<? super Apple> holder_five= new Holder_five<Fruit>();
        holderFive1 =new Holder_five<>(new Apple() );
        Fruit fruit= holderFive1.getValue();
        d=(Apple) holderFive1.getValue();

        try {
            Orange orange=(Orange) holderFive1.getValue();
        } catch (Exception e) {
            System.out.println(e);
        }

//        holderFive1.setValue(new Apple());
//        holderFive1.setValue(new Fruit());
        System.out.println(holderFive1.equals(d));
    }
}
