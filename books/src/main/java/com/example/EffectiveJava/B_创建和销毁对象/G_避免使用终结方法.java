package com.example.EffectiveJava.B_创建和销毁对象;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class G_避免使用终结方法 {

    /**
     * 1.终结方法的缺点在于其不能保证被立即执行。
     * 2.从一个对象不可达到其终结方法被执行，会花费相当长的时间。
     * 3.如果用终结方法去关闭文件，可能直到文件打开资源消耗光了，终结方法都不一定会被执行。
     * 4.可能当一个对象被回收的时候，终结方法根本就没执行过
     * 5.可能在一个JVM中终结方法被执行了，但是另一个中却不会被执行
     */
}
