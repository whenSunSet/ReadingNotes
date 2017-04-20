package com.example.IntroductionToAlgorithms.M_贪心算法;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.PriorityQueue;

/**
 * Created by heshixiyang on 2017/4/20.
 */
public class B_HuffmanCoding {
    public static class Node implements Comparable{
        int frequency;
        char c;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int frequency, char c) {
            this.frequency = frequency;
            this.c = c;
        }

        @Override
        public int compareTo(Object o) {
            Node nodeOne=this;
            Node nodeTwo=(Node)o;
            if (nodeOne==null||nodeTwo==null)return 0;
            if (nodeOne.frequency>nodeTwo.frequency){
                return 1;
            }else if (nodeOne.frequency<nodeTwo.frequency){
                return -1;
            }else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        int size=10;
        int[] A= Util.getRandomIntListHasBounder(10,100);
        Node root;
        PriorityQueue<Node> queue=new PriorityQueue<>(size);
        for (int i = 0; i < A.length; i++) {
            Node node=new Node(A[i],(char)('A'+i));
            queue.add(node);
        }
        root=huffmanCoding(queue);
    }

    public static Node huffmanCoding(PriorityQueue<Node> queue){
        /**
         * huffmanCoding(queue)
         * while queue.size > 1
         *      nodeOne=queue.pop
         *      nodeTwo=queue.pop
         *      nodeThree.frequency=nodeOne.frequency+nodeTwo.frequency
         *      nodeThree.leftChild=nodeOne
         *      nodeThree.rightChild=nodeTwo
         *      queue.push nodeThree
         * return queue.pop
         */
        if (queue.size()==0)return null;
        if (queue.size()==1)return queue.poll();
        Node nodeOne,nodeTwo;
        while (queue.size()>1){
            Node nodeThree=new Node(0,' ');
            nodeOne=queue.poll();
            nodeTwo=queue.poll();
            nodeThree.frequency=nodeOne.frequency+nodeTwo.frequency;
            nodeThree.leftChild=nodeOne;
            nodeThree.rightChild=nodeTwo;
            nodeOne.parent=nodeThree;
            nodeTwo.parent=nodeThree;
            queue.add(nodeThree);
        }
        return queue.poll();
    }

}
