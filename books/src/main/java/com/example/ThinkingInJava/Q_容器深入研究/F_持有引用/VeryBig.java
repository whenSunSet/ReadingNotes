package com.example.ThinkingInJava.Q_容器深入研究.F_持有引用;

/**
 * Created by heshixiyang on 2017/1/22.
 */
public class VeryBig {
    private static final int SIZE=1000;
    private long[] la=new long[SIZE];
    private String ident;
    public VeryBig(String id){
        ident=id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(("Finalizing " + ident));
    }

    @Override
    public String toString() {
        return ident;
    }
}
