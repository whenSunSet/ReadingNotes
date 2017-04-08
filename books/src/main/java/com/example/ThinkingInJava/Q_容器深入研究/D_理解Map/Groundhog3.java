package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
public class Groundhog3 extends Groundhog {
    public Groundhog3(int number) {
        super(number);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Gorundhog2 && (number==((Gorundhog2)obj).number);
    }
}
