package com.example.ThinkingInJava.Q_容器深入研究.F_持有引用;

/**
 * Created by heshixiyang on 2017/1/22.
 */
public class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element&&
                ident.equals(((Element)obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(("Finalizing " + getClass().getSimpleName() + " " + ident));
    }
}
