package com.example.IntroductionToAlgorithms.util;

import java.util.Random;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class CapabilityTest{
    public static int seed=47;
    public static int size=5;
    public static int bounder=100;
    public interface Algorithm{
        void action(Object o,int[] A);
    }

    enum Flag {
        Algorithm_ONE_BETTER("算法一更好"),Algorithm_TWO_BETTER("算法二更好"),EQUALS("两个算法差不多");
        String note;
        Flag(String s) {
            note=s;
        }

        @Override
        public String toString() {
            return note;
        }
    }
    public static void getPerformanceOFTheIntersection(Algorithm algorithmOne, Algorithm algorithmTwo){
        long algorithmOneTime=0;
        long algorithmTwoTime=1;
        while (algorithmOneTime<algorithmTwoTime && size<=Util.MAX){
            System.out.println(("数据大小:" + size));
            System.out.println(compareAlgorithm(algorithmOne, new ListParams(0,size-1), algorithmTwo, new ListParams(0,size-1)));
            size=2*size;
            System.out.println("");
        }
    }

    public static Flag compareAlgorithm(Algorithm algorithmOne, Object algorithmOneParams, Algorithm algorithmTwo, Object algorithmTwoParams){
        long algorithmOneTime=getAlgorithmIntervalTime(algorithmOne,algorithmOneParams,getData());
        long algorithmTwoTime=getAlgorithmIntervalTime(algorithmTwo,algorithmTwoParams,getData());
        if (algorithmOneTime<algorithmTwoTime)return Flag.Algorithm_ONE_BETTER;
        else if (algorithmOneTime>algorithmTwoTime)return Flag.Algorithm_TWO_BETTER;
        else return Flag.EQUALS;
    }

    public static long getAlgorithmIntervalTime(Algorithm algorithm,Object o,int[] A){
        long startTime=System.currentTimeMillis();
        algorithm.action(o,A);
        long endTime=System.currentTimeMillis();
        return endTime-startTime;
    }

    public static int[] getData(){
        Random random=new Random(seed);
        int[] ints=new int[size];
        for (int i = 0; i < size; i++) {
            if (bounder!=0)ints[i]=random.nextInt(bounder);
            else ints[i]=random.nextInt();

            if (ints[i]%2==1)ints[i]=-ints[i];
        }
        return ints;
    }

}
