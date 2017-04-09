package com.example.IntroductionToAlgorithms.F_堆排序;

import com.example.IntroductionToAlgorithms.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.example.IntroductionToAlgorithms.F_堆排序.A_HeapSort.Node;
/**
 * Created by heshixiyang on 2017/4/9.
 */
public class B_Test {
    public static void main(String[] args) {
        int[] A= Util.getRandomIntListHasBounder(10,100);
        ArrayList<Node> nodeArrayList=new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            minHeapInsert(nodeArrayList,A[i],0);
        }
    }

    //6.5.3
    public static void minHeapInsert(ArrayList<Node> nodes, int data,int listId){
        /**
         * minHeapInsert(nodes,data)
         * put data into nodes
         * if nodes.length is 1
         *      return;
         * data.parentNum=nodes.length%2
         * parentNode=nodes[data.parentNum]
         * if nodes.length%2 is 0
         *      parentNode.leftNode=nodes[nodes.length]
         * if nodes.length%2 is 1
         *      parentNode.rightNode=nodes[nodes.length]
         * maintainHeapUp(nodes,nodes.length)
         */
        Node addNode=new Node(data,nodes.size());
        addNode.listId=listId;
        nodes.add(addNode);
        if (nodes.size()==1)return;
        addNode.parentNum=nodes.size()/2-1;
        A_HeapSort.Node parentNode=nodes.get(addNode.parentNum);
        if (nodes.size()%2==0)parentNode.leftNode=nodes.get(nodes.size()-1);
        if (nodes.size()%2==1)parentNode.rightNode=nodes.get(nodes.size()-1);
        maintainMinHeapUp(nodes,nodes.size()-1);
    }

    public static void maintainMinHeapUp(ArrayList<Node> nodes, int i){
        /**
         * maintainMinHeapUp(nodes,i)
         * parentNode=nodes[nodes[i].parentNum]
         * leftNode=parentNode.leftNode
         * rightNode=parentNode.rightNode
         * smallest=parentNode.num
         * if leftNode!=null and leftNode.data>nodes[i].data
         *      smallest=leftNode.num
         * if rightNode!=null and rightNode.data>nodes[smallest].data
         *      smallest=rightNode.num
         * if largest!=i
         *      exchange parentNode.data with nodes[smallest].data
         *      maintainMinHeapUp(nodes,smallest)
         */
        if (i==0)return;
        Node parentNode=nodes.get(nodes.get(i).parentNum),leftNode=parentNode.leftNode,rightNode=parentNode.rightNode;
        int smallest=parentNode.num,temp;
        if (leftNode!=null&&leftNode.data<parentNode.data)smallest=leftNode.num;
        if (rightNode!=null&&rightNode.data<nodes.get(smallest).data)smallest=rightNode.num;
        if (smallest!=parentNode.num){
            temp=parentNode.data;
            parentNode.data=nodes.get(smallest).data;
            nodes.get(smallest).data=temp;

            temp=parentNode.listId;
            parentNode.listId=nodes.get(smallest).listId;
            nodes.get(smallest).listId=temp;

            maintainMinHeapUp(nodes,parentNode.num);
        }
    }

    //6.5.7：
    //1.先进先出队列：搞一个最小堆，然后每次插入的data为自增，这样一来在最顶上的总是先进入的节点
    //2.栈：先进后出，搞一个最大堆，然后每次插入的data为自增，这样一来在最顶上的总是后进入的节点

    //6.5.8：将i和堆中最后一个节点的data互换，然后删除最后一个节点，然后将i向下保持堆的性质

    //6.8.9   用最小堆进行多路归并 有序链表
    public static void mergeLinkedList(List<LinkedListNode> roots){
        int k=roots.size();
        LinkedListNode nowRootNode=new LinkedListNode(0,Util.MIN,null);
        LinkedListNode root=new LinkedListNode(0,Util.MIN,nowRootNode);
        ArrayList<Node> nodeArrayList=new ArrayList<>();
        for (int i = 0; i < roots.size(); i++) {
            minHeapInsert(nodeArrayList,roots.get(i).data,roots.get(i).listId);
            roots.set(i,roots.get(i).child);
        }
        while (k>=0){
            LinkedListNode node=new LinkedListNode(nodeArrayList.get(0).listId,nodeArrayList.get(0).data,null);
            nowRootNode.child=node;
            nowRootNode=node;

            if (roots.get(nodeArrayList.get(0).listId)==null){
                roots.remove(nodeArrayList.get(0).listId);
                nodeArrayList.get(0).data=roots.get(0).data;
                nodeArrayList.get(0).listId=0;
                k--;
            }
            nodeArrayList.get(0).data=roots.get(nodeArrayList.get(0).listId).data;
            maintainMinHeapUp(nodeArrayList,0);
            roots.set(nodeArrayList.get(0).listId,roots.get(nodeArrayList.get(0).listId).child);
        }
    }

    public static class LinkedListNode{
        public int listId;
        public int data;
        public LinkedListNode child;

        public LinkedListNode(int listId, int data, LinkedListNode child) {
            this.listId = listId;
            this.data = data;
            this.child = child;
        }
    }

}
