package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class SelfBounding_eight {
    public static class SelfBounded<T extends SelfBounded<T>>{
        T element;

        public SelfBounded<T> setElement(T element) {
            this.element = element;
            return this;
        }

        public T getElement() {
            return element;
        }
    }

    static class A extends SelfBounded<A>{}
    static class B extends SelfBounded<A>{}

    static class C extends SelfBounded<C>{
        C setAndGet(C c){
            setElement(c);
            return getElement();
        }
    }

    static class D{}

    /*
    * 有了自限定之后，子类泛型就不能再放其他参数了。
    * */
//   static  class E extends SelfBounded<D>{}

    /*
    *
    * 当然不放任何泛型参数的时候，其默认就是基类了。
    * */
    static class F extends SelfBounded{}

    /*
    * 从上面我们可以看到，自限定类所要做的事情就是强制要求将现在正在定义的类或者从基类导出的子类作为泛型参数传递给基类，
    * 以方便我们使用具体的类而不是基类。
    * */
    public static void main(String[] args) {
        A a=new A();
        a.setElement(new A());
        a=a.setElement(new A()).getElement();
        C c=new C();
        c=c.setAndGet(new C());
    }
    /*
    * 我们还可以把自限定用在方法中，这样可以防止这个方法被应用于除这个自限定参数以外的事物上。
    * */
    static <T extends SelfBounded<T>> T f(T arg){
        return arg.setElement(arg).getElement();
    }
}
