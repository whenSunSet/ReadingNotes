package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
public class Gorundhog2 extends Groundhog {

    public Gorundhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Gorundhog2 && (number==((Gorundhog2)obj).number);
    }
}
