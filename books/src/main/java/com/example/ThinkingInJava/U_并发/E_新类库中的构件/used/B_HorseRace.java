package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;

import com.example.ThinkingInJava.U_并发.E_新类库中的构件.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/6.
 */
/*
* 在CyclicBarrier中提供一个任务，可以让其他任务在这个任务完成之后再运行，并且可以多次触发。
* */
public class B_HorseRace {
    static final int FINISH_LINE=75;
    private List<Horse> horses=new ArrayList<>();
    private ExecutorService executorService= Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public B_HorseRace(int horsesNum, final int pause) {
        barrier=new CyclicBarrier(horsesNum, new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder=new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    stringBuilder.append("=");
                }
                System.out.println(stringBuilder);
                for (Horse horse:horses)
                    System.out.println(horse.tracks());
                for (Horse horse:horses)
                    if (horse.getStrides()>=FINISH_LINE){
                        System.out.println((horse + "Won!"));
                        executorService.shutdownNow();
                        return;
                    }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < horsesNum; i++) {
            Horse horse=new Horse(barrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int horseNum=7;
        int pause=200;
        new B_HorseRace(horseNum,pause);
    }
}
