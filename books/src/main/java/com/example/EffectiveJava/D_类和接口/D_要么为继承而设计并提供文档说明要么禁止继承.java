package com.example.EffectiveJava.D_类和接口;

/**
 * Created by heshixiyang on 2017/5/28.
 */
public class D_要么为继承而设计并提供文档说明要么禁止继承 {
    /**
     * 要设计一个可被继承的类，需要做的事情
     * 1.需要在文档中精确描述覆盖每个方法带来的影响，如可覆盖方法的自用性
     *   如：AbstractCollection中，文档很清楚的说明了如果覆盖了iterator方法会影响remove方法
     * 2.对于为了继承而设计的类，唯一的测试方法就是为其编写子类，如果编写了3个子类都没有使用到某些受保护的成员，那么就可设置为私有
     * 3.构造器不能调用可被覆盖的方法，
     * 4.对于不是为了继承而设计的普通类，可以禁止子类化
     * 5.对于自用性，可以使用替代私有辅助方法代替需要自用的可覆盖的方法
     */
}
