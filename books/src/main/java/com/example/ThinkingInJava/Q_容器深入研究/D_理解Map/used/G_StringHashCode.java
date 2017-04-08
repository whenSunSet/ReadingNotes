package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map.used;

/**
 * Created by heshixiyang on 2017/1/21.
 */
/*
* 设计HashCode有几个重要的点：
* 1.无论何时同一对象生成的hashCode要相同，否则将对象放入HashMap之后这个对象就取不出来了。
* 2.不该让hashCode依赖于具有唯一性的对象信息，比如说默认的hashCode就是取对象的地址，那么就会出现我之前说的问题
* 3.hashCode应该根据对象的内容生成散列码，并不需要独一无二，因为我们还有equals方法做最后的判断。
* 4.hashCode应该产生分布均匀的散列码，极端的情况就会退化成我们的SlowMap。
* */
public class G_StringHashCode {
    public static void main(String[] args) {
        String[] hellos="Hello Hello".split(" ");
        System.out.println(hellos[0]);
        System.out.println(hellos[1]);
    }
}
