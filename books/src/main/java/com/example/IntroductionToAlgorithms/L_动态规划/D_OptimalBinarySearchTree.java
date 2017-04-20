package com.example.IntroductionToAlgorithms.L_动态规划;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class D_OptimalBinarySearchTree {
    public static void main(String[] args) {
        int n=5;
        float[] p={0,0.15f,0.1f,0.05f,0.1f,0.2f},
                q={0.05f,0.1f,0.05f,0.05f,0.05f,0.1f};
        e=new float[n+2][n+1];
        w=new float[n+2][n+1];
        root=new float[n+1][n+1];
        optimalBinarySearchTree(p,q,n);
    }
    static float[][] e,w,root;
    public static void optimalBinarySearchTree(float[] p,float[] q,int n){
        /**
         * optimalBinarySearchTree(p,q,n)
         * let e[1...n+1,0...n],w[1...n+1,0...n],root[1...n,1...n] to be new array
         * for i=1 to n+1
         *      e[i,i-1]=q[i-1]
         *      w[i,i-1]=q[i-1]
         * for l=1 to n
         *      for i=1 to n-l+1
         *          j=i+l-1
         *          w[i,j]=w[i,j-1]+p[j]+q[j]
         *          e[i,j]=MAX
         *          for r=i to j
         *              temp=e[i,r-1]+e[r+1,j]+w[i,j]
         *              if temp<=e[i,j]
         *                  e[i,j]=temp
         *                  root[i,j]=r
         *
         */
        for (int i = 1; i <=n+1; i++) {
            e[i][i-1]=q[i-1];
            w[i][i-1]=q[i-1];
        }
        for (int l = 1; l < n; l++) {
            for (int i = 1; i <n-l+1; i++) {
                int j=i-1+l;
                e[i][j]= Util.MAX;
                w[i][j]=w[i][j-1]+q[j]+p[j];
                for (int r = i; r <=j; r++) {
                    float temp=e[i][r-1]+e[r+1][j]+w[i][j];
                    if (temp<=e[i][j]){
                        e[i][j]=temp;
                        root[i][j]=r;
                    }
                }
            }
        }
    }
}
