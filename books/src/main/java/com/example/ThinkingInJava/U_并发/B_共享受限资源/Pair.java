package com.example.ThinkingInJava.U_并发.B_共享受限资源;

/**
 * Created by heshixiyang on 2017/2/5.
 */
public class Pair  {
    private int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX(){x++;}
    public void incrementY(){y++;}

    @Override
    public String toString() {
        return "x: "+x+" , "+"y: "+y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equals: "+Pair.this);
        }
    }

    public void checkState(){
        if (x!=y)
            throw  new PairValuesNotEqualException();
    }
}
