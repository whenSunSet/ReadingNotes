package com.example.EffectiveJava.C_对于所有对象都通用的方法;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class D_谨慎覆盖clone {
    /**
     * 1.Cloneable 是一个空的接口，决定了clone()的实现方式,如果一个类实现了Cloneable，那么Object的clone()方法就会返回该对象的逐域拷贝，否则会抛出异常
     * 2.如果实现了Cloneable，就表示该类和所偶超类都要遵循一个机制：无需构造器就可以创建对象
     * 3.Object的clone()在拷贝的的时候是拷贝引用和数值，所以原对象和clone对象中域的引用是指向相同的对象，因此如果域引用了可变的对象，那么就会造成问题。
     * 4.为了解决3的问题，要对一个对象实施clone()的时候，需要根据类的域的类型来判断是否要对域进行clone()，而在对域进行clone()的时候同样也会有3的问题。
     * 5.所以为了克隆复杂的对象，最后的方法就是先调用Object的clone(),然后将所有域置为空白，最后调用类的api来重新产生对象状态。
     * 6.另一个实现对象拷贝的办法就是提供一个对象拷贝构造器或者拷贝工厂。
     */
}
