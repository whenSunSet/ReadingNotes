package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

/**
 * Created by heshixiyang on 2017/1/21.
 */
public class Individual implements Comparable<Individual> {
    private static long counter=0;
    private final long id=counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+(name==null?"":" "+name);
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual&&
                id==((Individual)obj).id;
    }

    @Override
    public int hashCode() {
        int result=37;
        if (name!=null)result=37*result+name.hashCode();
        result=37*result+(int) id;
        return result;
    }

    @Override
    public int compareTo(Individual o) {
        return 0;
    }
}
