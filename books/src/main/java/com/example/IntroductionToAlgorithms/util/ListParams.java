package com.example.IntroductionToAlgorithms.util;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class ListParams{
    private int start;
    private int end;

    public ListParams(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
