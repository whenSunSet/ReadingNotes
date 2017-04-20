package com.example.IntroductionToAlgorithms.N_图论;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.HashMap;
import java.util.List;

/**
 * Created by heshixiyang on 2017/4/20.
 */
public class A_Map {
    public static class Node{
        public Node previousNode;
        public int flag;
        public int dataNum= Util.MAX;
        public Object data;

        public Node(int flag) {
            this.flag = flag;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Node)obj).flag==this.flag;
        }
    }

    public static class Map{
        HashMap<Integer,Node> node=new HashMap<>();
        int[][] line;

        public Map(List<Node> nodes, int[][] line) {
            this.line = line;
            for (int i = 0; i < nodes.size(); i++)
                node.put(nodes.get(i).flag,nodes.get(i));
        }

        public Node getNode(int flag){
            return node.get(flag);
        }
        public int getLine(Node one, Node two){
            if (line==null)return 0;
            return line[one.flag][two.flag];
        }
    }

    public static Map createMap(){
        int size=10;
        int[][] line=new int[10][10];
        return null;
    }

}
