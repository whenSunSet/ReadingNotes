package com.example.IntroductionToAlgorithms.N_图论;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by heshixiyang on 2017/4/20.
 */
public class C_GenericMst {
    public static void main(String[] args) {

    }

    public static class NodeLine{
        int length;
        int flagOne;
        int flagTwo;

        public NodeLine(int length, int flagOne, int flagTwo) {
            this.length = length;
            this.flagOne = flagOne;
            this.flagTwo = flagTwo;
        }

        @Override
        public boolean equals(Object obj) {
            return ((NodeLine)obj).length==this.length;
        }

    }

    static Queue<NodeLine> queue=new PriorityQueue<>();
    static HashMap<Integer,HashSet<A_Map.Node>> trees=new HashMap<>();
    public static int[][] kruskal(A_Map.Map map){
        int[][] line=new int[map.line.length][map.line.length];
        for (Integer i:map.node.keySet()){
            HashSet<A_Map.Node> nodeSet=new HashSet<>();
            nodeSet.add(map.node.get(i));
            trees.put(i,nodeSet);
        }
        for (int i = 0; i < map.line.length; i++) {
            A_Map.Node nowNode=map.getNode(i);
            for (int j=nowNode.flag+1;j<map.line.length;j++){
                queue.add(new NodeLine(map.line[i][j],i,j));
            }
        }

        while (trees.keySet().size()!=0){
            NodeLine nl=queue.poll();
            if (findRoot(map.getNode(nl.flagOne),map)!=findRoot(map.getNode(nl.flagTwo),map)){
                line[nl.flagOne][nl.flagTwo]=map.line[nl.flagOne][nl.flagTwo];
                trees.remove(nl.flagTwo);
            }
        }
        return line;
    }

    public static int[][] prim(A_Map.Map map){
        int[][] line=new int[map.line.length][map.line.length];
        HashSet<A_Map.Node> nodeSet=new HashSet<>();
        while (nodeSet.size()<map.line.length){

        }
        return null;
    }

    private static A_Map.Node findRoot(A_Map.Node node,A_Map.Map map){
        for (Integer i:trees.keySet()){
            HashSet<A_Map.Node> set=trees.get(i);
            if (set.contains(node)){
                return map.getNode(i);
            }
        }
        return null;
    }
}
