package com.example.EffectiveJava.C_对于所有对象都通用的方法;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class A_覆盖equals时请遵守通用规定 {
    /**
     * 在不覆盖equals的情况下，一个实例只和自身相等，只要满足了以下条件之一就不需要覆盖equals
     * 1.类的每个实例唯一，这是Object的equals提供的
     * 2.用户部关心该类的两个实例是否存在逻辑上的相等。
     * 3.超类覆盖了equals，其行为对子类也适用
     * 4.类是私有或者包级私有，就可以确认其equals方法永远不会被调用，此时应该在其equals方法中抛出异常
     *
     * 在什么时候应该覆盖equals呢？
     * 1.这个类我们需要比较其逻辑上的相等，如Integer
     * 2.该类的超类没有覆盖equals实现期望的行为
     *
     * 覆盖一个equals的时候要满足以下几个关系：
     * 1.自反性：非null，x.equals(x)为true
     * 2.对称性：非null，x.equals(y)为true 有 y.equals(x)为true
     * 3.传递性：非null，x.equals(y)为true，y.equals(z)为true 有 x.equals(z)为true
     * 4.一致性：非null，x.equals(y)，只要x，y没改变，一直返回相同的结果
     *
     * 覆盖equals有以下几个技巧
     * 1.先使用==，判断两个随想是不是同一个引用，以提高性能
     * 2.使用instanceof判断是否是正确的类型，否则返回false
     * 3.2的基础上把参数转换成正确的类型
     * 4.对类中每个需要比较的域进行检测比较，如果是引用可以递归调用equals
     * 5.编写完了之后，问自己equals是否符合前面的四个关系
     *
     * 覆盖equals的告诫：
     * 1.覆盖equals时候，总要覆盖hashCode
     * 2.不要让equals太过智能，比如一个File类型和一个String的文件路径相等
     * 3.不要将equals中传入的Object改成其他类型。
     */
}
