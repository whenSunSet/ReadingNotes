package com.example.IntroductionToAlgorithms.F_堆排序;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class A_HeapSort {
    public static class Node{
        public int data;
        public int num;
        public int parentNum;
        public Node leftNode;
        public Node rightNode;
        public int listId;

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
        ArrayList<Node> nodeArrayList=new ArrayList<>();
        Node[] N=new Node[A.length];
        for (int i = 0; i < A.length; i++) {
            N[i]=new Node(A[i],i);
            insert(nodeArrayList,A[i]);
        }
        createBigHeap(N);
        heapSort(N);
    }

    public static void heapSort(Node[] nodes){
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[0]);
            nodes[0].data=Util.MIN;
            maintainHeapDown(nodes,0);
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
         *      maintainHeapDown(nodes,i)
         */

        for (int i = 0; i < nodes.length/2; i++) {
            nodes[i].leftNode=nodes[2*i+1];
            if (2*(i+1)<=(nodes.length-1))
                nodes[i].rightNode=nodes[2*(i+1)];
        }
        for (int i = (nodes.length-1)/2; i>=0; i--) {
            maintainHeapDown(nodes,i);
        }
    }

    public static void maintainHeapDown(Node[] nodes, int i){
        /**
         * maintainHeapDown(nodes,i)
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
         *      maintainHeapDown(nodes,largest)
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
            maintainHeapDown(nodes,largest);
        }
    }

    public static void insert(ArrayList<Node> nodes, int data){
        /**
         * insert(nodes,data)
         * put data into nodes
         * data.parentNum=nodes.length%2
         * parentNode=nodes[data.parentNum]
         * if nodes.length%2 is 0
         *      parentNode.leftNode=nodes[nodes.length]
         * if nodes.length%2 is 1
         *      parentNode.rightNode=nodes[nodes.length]
         * maintainHeapUp(nodes,nodes.length)
         */
        Node addNode=new Node(data,nodes.size());
        nodes.add(addNode);
        if (nodes.size()==1)return;
        addNode.parentNum=nodes.size()/2-1;
        Node parentNode=nodes.get(addNode.parentNum);
        if (nodes.size()%2==0)parentNode.leftNode=nodes.get(nodes.size()-1);
        if (nodes.size()%2==1)parentNode.rightNode=nodes.get(nodes.size()-1);
        maintainHeapUp(nodes,nodes.size()-1);
    }

    public static void maintainHeapUp(ArrayList<Node> nodes, int i){
        /**
         * maintainHeapUp(nodes,i)
         * parentNode=nodes[nodes[i].parentNum]
         * leftNode=parentNode.leftNode
         * rightNode=parentNode.rightNode
         * largest=parentNode.num
         * if leftNode!=null and leftNode.data>nodes[i].data
         *      largest=leftNode.num
         * if rightNode!=null and rightNode.data>nodes[largest].data
         *      largest=rightNode.num
         * if largest!=i
         *      exchange parentNode.data with nodes[largest].data
         *      maintainHeapUp(nodes,largest)
         */
        if (i==0)return;
        Node parentNode=nodes.get(nodes.get(i).parentNum),leftNode=parentNode.leftNode,rightNode=parentNode.rightNode;
        int largest=parentNode.num,temp;
        if (leftNode!=null&&leftNode.data>parentNode.data)largest=leftNode.num;
        if (rightNode!=null&&rightNode.data>nodes.get(largest).data)largest=rightNode.num;
        if (largest!=parentNode.num){
            temp=parentNode.data;
            parentNode.data=nodes.get(largest).data;
            nodes.get(largest).data=temp;
            maintainHeapUp(nodes,parentNode.num);
        }
    }
}
