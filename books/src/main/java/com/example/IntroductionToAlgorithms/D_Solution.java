package com.example.IntroductionToAlgorithms;

/**
 * Created by heshixiyang on 2017/4/25.
 */
public class D_Solution {
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

    }

    public static double solution(int[][] A,Point[] B,int n,int m){
        A[0][0]=1;
        int max=0,can=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0||j==0){
                    A[i][j]=1;
                }else {
                    A[i][j]=A[i-1][j]+A[j-1][i];
                }
            }
        }
        max=A[n-1][m-1];
        for (int i = 0; i < B.length; i++) {
            A[B[i].x][B[i].y]=0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j]!=0){
                    if (i==0||j==0){
                        A[i][j]=1;
                    }else {
                        A[i][j]=A[i-1][j]+A[j-1][i];
                    }
                }
            }
        }
        can=A[n-1][m-1];
        return (double)(can/max);
    }
}
