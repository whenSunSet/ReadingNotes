package com.example.IntroductionToAlgorithms.N_图论;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.HashSet;

/**
 * Created by heshixiyang on 2017/4/20.
 */

public class D_Dijkstra {
    public static void main(String[] args) {

    }

    public static void dijkstra(A_Map.Map map, A_Map.Node start,int size){
        HashSet<A_Map.Node> allNode=new HashSet<>();
        for (int i = 0; i < map.node.keySet().size(); i++) {
            allNode.add(map.getNode(i));
        }
        A_Map.Node middle=start;
        allNode.remove(middle);
        for (int j = 0; j <size; j++) {
            for (int i = 0; i < size; i++) {
                relaxed(map,middle,map.getNode(i));
            }
            A_Map.Node minNode=new A_Map.Node(0);
            minNode.dataNum= Util.MAX;
            for (A_Map.Node node:allNode){
                if (minNode.dataNum<=node.dataNum)
                    minNode=node;
            }
            middle=minNode;
            allNode.remove(middle);
        }

    }

    public static void relaxed(A_Map.Map map,A_Map.Node middle, A_Map.Node end){
        if (middle.dataNum+map.line[middle.flag][end.flag]<=end.dataNum){
            end.dataNum=middle.dataNum+map.line[middle.flag][end.flag];
            end.previousNode=middle;
        }
    }
}
