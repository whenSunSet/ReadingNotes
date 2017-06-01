package com.example.EffectiveJava.G_方法;

import java.util.*;

/**
 * Created by heshixiyang on 2017/6/1.
 */
public class A_必要时进行保护性拷贝 {
    /**
     * 在返回一个类中可变的组件的时候，如果我们不希望返回到客户端的组件的改变会影响到原来组件。
     * 那么我们需要进行保护性拷贝，即重新创建一个与内部组件信息相同的组件然后返回，这里可以用clone方法。
     * 我们可能会担心性能的问题，所以说如果实在不想多创建对象，那么就在文档中标明，不想该组件被改变
     */

    public static final class Period{
        private final Date start;
        private final Date end;

        public Period(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        //我们可能希望start和end不受外部的改变而改变，但是这个引用虽然不会改变，但是内部的数值会发送改变，所以我们可以采取保护性拷贝
//        public Date getStart() {
//            return start;
//        }
//
//        public Date getEnd() {
//            return end;
//        }

        public Date getStart() {
            return new Date(start.getTime());
        }

        public Date getEnd() {
            return new Date(end.getTime());
        }
    }
}
