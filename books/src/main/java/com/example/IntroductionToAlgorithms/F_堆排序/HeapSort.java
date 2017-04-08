package com.example.IntroductionToAlgorithms.F_堆排序;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class HeapSort {
    public static class Node{
        public int data;
        public int num;
        public Node leftNode;
        public Node rightNode;

        public Node(int data, int num) {
            this.data = data;
            this.num = num;
            this.leftNode = null;
            this.rightNode = null;
        }

        @Override
        public String toString() {
            return " "+data;
        }
    }

    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        Node[] N=new Node[A.length];
        for (int i = 0; i < A.length; i++) {
            N[i]=new Node(A[i],i);
        }
        createBigHeap(N);
        heapSort(N);
    }

    public static void heapSort(Node[] nodes){
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[0]);
            nodes[0].data=Util.MIN;
            maintainHeap(nodes,0);
        }
    }

    public static void createBigHeap(Node[] nodes){
        /**
         * createBigHeap(nodes)
         * for i=1 to nodes.length/2
         *      node=nodes[i]
         *      node.leftNode=nodes[2*i]
         *      if 2*i+1<=nodes.length
         *          node.rightNode=nodes[2*i+1]
         * for i=nodes.length/2 to 1
         *      maintainHeap(nodes,i)
         */

        for (int i = 0; i < nodes.length/2; i++) {
            nodes[i].leftNode=nodes[2*i+1];
            if (2*(i+1)<=(nodes.length-1))
                nodes[i].rightNode=nodes[2*(i+1)];
        }
        for (int i = (nodes.length-1)/2; i>=0; i--) {
            maintainHeap(nodes,i);
        }
    }

    public static void maintainHeap(Node[] nodes,int i){
        /**
         * maintainHeap(nodes,i)
         * leftNode=nodes[i].leftNode
         * rightNode=nodes[i].rightNode
         * largest=i
         * if leftNode==null and rightNode==null
         *      return
         * if leftNode!=null and leftNode.data>nodes[i].data
         *      largest=leftNode.num
         * if rightNode!=null and rightNode.data>nodes[largest].data
         *      largest=rightNode.num
         * if largest!=i
         *      exchange nodes[i].data with nodes[largest].data
         *      maintainHeap(nodes,largest)
         *
         */

        Node leftNode=nodes[i].leftNode,rightNode=nodes[i].rightNode;
        int largest=i,temp;
        if (leftNode==null&&rightNode==null)return;
        if (leftNode!=null&&leftNode.data>nodes[i].data)largest=leftNode.num;
        if (rightNode!=null&&rightNode.data>nodes[largest].data)largest=rightNode.num;
        if (largest!=i){
            temp=nodes[i].data;
            nodes[i].data=nodes[largest].data;
            nodes[largest].data=temp;
            maintainHeap(nodes,largest);
        }
    }
}
