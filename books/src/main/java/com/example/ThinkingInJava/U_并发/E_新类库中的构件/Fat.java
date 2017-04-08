package com.example.ThinkingInJava.U_并发.E_新类库中的构件;

/**
 * Created by heshixiyang on 2017/2/7.
 */
public class Fat {
    private volatile double d;
    private static int counter=0;
    private final int id=counter++;

    public Fat() {
        for (int i = 0; i < 10000; i++) {
            d+=(Math.PI+Math.E)/(double)i;
        }
    }

    public void operation(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat id: "+id;
    }
}
