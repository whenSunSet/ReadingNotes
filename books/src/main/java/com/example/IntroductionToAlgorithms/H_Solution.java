package com.example.IntroductionToAlgorithms;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by heshixiyang on 2017/4/28.
 */
public class H_Solution {
    public static ConcurrentSkipListSet<String> userCacheSet=new ConcurrentSkipListSet<>();

    public static void main(String[] args) {
        userCacheSet.add("1");
        userCacheSet.add("2");
        userCacheSet.add("3");
        userCacheSet.add("4");
        userCacheSet.add("5");
        userCacheSet.add("6");
        userCacheSet.add("7");
        userCacheSet.pollFirst();
        userCacheSet.pollLast();
        userCacheSet.remove("5");
    }
}
