package com.example.ThinkingInJava.Q_容器深入研究.D_理解Map;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/1/21.
 */
public class Prediction {
    private static Random random=new Random(47);
    private boolean shadow=random.nextDouble()>0.5;

    @Override
    public String toString() {
        if (shadow)
            return "Six more weeks of Winter";
        else
            return "Early Spring";
    }
}
