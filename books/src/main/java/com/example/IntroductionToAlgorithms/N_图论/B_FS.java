package com.example.IntroductionToAlgorithms.N_图论;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by heshixiyang on 2017/4/20.
 */
public class B_FS {
    public static void main(String[] args) {
        int size=10;
        List<A_Map.Node> nodes=new ArrayList<>();
        int[] flags={0,1,2,3,4,5,6,7,8,9};
        int[][] line=new int[size][size];
        for (int i = 0; i <size; i++) {
            nodes.add(new A_Map.Node(flags[i]));
            for (int j = 0; j < size; j++) {
                line[i][j]=Util.MAX;
            }
        }
        line[0][1]=1;line[1][2]=1;line[1][3]=1;line[1][4]=1;line[1][5]=1;
        line[2][6]=1;line[3][7]=1;line[4][8]=1;line[5][9]=1;
        line[2][3]=1;line[3][4]=1;line[4][5]=1;line[2][5]=1;

        BFS(new A_Map.Map(nodes,line));
    }

    public static void BFS(A_Map.Map map){
        Queue<A_Map.Node> queue=new LinkedList<>();
        queue.add(map.getNode(0));
        Set<A_Map.Node> nodeSet=new HashSet<>();
        while (queue.size()!=0){
            A_Map.Node nowNode=queue.poll();
            nodeSet.add(nowNode);

            System.out.println(nowNode.flag);

            for (int i=nowNode.flag+1;i<map.line.length;i++){
                if (map.line[nowNode.flag][i]!= Util.MAX&&!nodeSet.contains(map.getNode(i))){
                    queue.add(map.getNode(i));
                    nodeSet.add(map.getNode(i));
                }
            }
        }
    }

    public static void DFS(A_Map.Map map){
        Queue<A_Map.Node> queue=new LinkedList<>();
        queue.add(map.getNode(0));
        Set<A_Map.Node> nodeSet=new HashSet<>();
        while (queue.size()!=0){
            A_Map.Node nowNode=queue.poll();
            nodeSet.add(nowNode);

            System.out.println(nowNode.flag);

            for (int i=nowNode.flag+1;i<map.line.length;i++){
                if (map.line[nowNode.flag][i]!= Util.MAX&&!nodeSet.contains(map.getNode(i))){
                    queue.add(map.getNode(i));
                    nodeSet.add(map.getNode(i));
                }
            }
        }
    }
}
