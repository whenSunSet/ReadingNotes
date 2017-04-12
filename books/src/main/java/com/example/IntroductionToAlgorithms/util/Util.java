package com.example.IntroductionToAlgorithms.util;

import java.util.Random;

/**
 * Created by heshixiyang on 2017/2/10.
 */
public class Util {

    public static final int MAX=10000000;
    public static final int MIN=-10000000;
    public static int[] getRandomIntList(int size){
        return getRandomIntListHasBounder(size,0);
    }

    public static int[] getRandomIntListHasBounder(int size,int bounder){
        Random random=new Random(47);
        int[] ints=new int[size];
        for (int i = 0; i < size; i++) {
            if (bounder!=0)ints[i]=random.nextInt(bounder);
            else ints[i]=random.nextInt();
        }
        Util.printList(ints);
        return ints;
    }

    public static byte[] getRandomByteListHasBounder(int size,int bounder){
        Random random=new Random(47);
        byte[] bytes=new byte[size];
        for (int i = 0; i < size; i++) {
            if (bounder!=0)bytes[i]=(byte)random.nextInt(bounder);
            else bytes[i]= (byte) random.nextInt();
        }
        Util.printList(bytes);
        return bytes;
    }

    public static byte[] getRandomByteListHasBounderSeedRandom(int size, int bounder){
        Random random=new Random(System.currentTimeMillis());
        byte[] bytes=new byte[size];
        for (int i = 0; i < size; i++) {
            if (bounder!=0)bytes[i]=(byte)random.nextInt(bounder);
            else bytes[i]= (byte) ((byte) random.nextInt()+1);
        }
        Util.printList(bytes);
        return bytes;
    }

    public static void printList(int[] ints){
        for (int i:ints) System.out.print(i+",");
        System.out.println("");
    }
    public static void printList(byte[] bytes){
        for (byte i:bytes) System.out.print(i+",");
        System.out.println("");
    }

}
