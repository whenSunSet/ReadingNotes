package com.example.IntroductionToAlgorithms.O_B树;

/**
 * Created by heshixiyang on 2017/5/3.
 */
public class A_BTree {
    public static class Root{
        public static Node root=null;
    }
    public static class Node{
        public static int maxNodeNum=5;
        public static int minNodeNum=maxNodeNum/2+1;

        public int[] nums=new int[maxNodeNum];
        public Object[] datas=new Object[maxNodeNum];
        public Node[] children =new Node[maxNodeNum+1];
        public Node brother;
        public Node parent;
        public int leftParentNum;
        public int rightParentNum;
        public int nowSize=0;

        public Node(Node brother, Node parent, int leftParentNum, int rightParentNum) {
            this.brother = brother;
            this.parent = parent;
            this.leftParentNum = leftParentNum;
            this.rightParentNum = rightParentNum;
        }

        public void readDisk(){
            for (int i = 0; i < nums.length; i++) {
                datas[i]=String .valueOf(nums);
            }
        }

        public void addData(Node node,int nodeWhere,int where){
            addData(node.nums[nodeWhere],node.datas[nodeWhere],node.children[where],node.children[nodeWhere+1],where);
        }

        public void addData(int num,Object data,Node leftChild,Node rightChild,int where){
            if (nowSize==0){
                nums[0]=num;
                datas[0]=data;
                children[0]=leftChild;
                children[1]=rightChild;
            }else if (nowSize<(where+1)){
                nums[where]=num;
                datas[where]=data;
                children[where]=leftChild;
                children[where+1]=rightChild;
            }else {
                children[where]=leftChild;
                int tempNum=num;
                Object tempData=data;
                Node tempChild=rightChild;
                for (int i = where; i <=nowSize; i++) {
                    int tN=nums[i];
                    Object tD=datas[i];
                    Node tC=children[i];

                    nums[i]=tempNum;
                    datas[i]=tempData;
                    children[i]=tempChild;

                    tempNum=tN;
                    tempData=tD;
                    tempChild=tC;
                }
            }
            nowSize++;
        }

        public void deleteData(int where,Node child){
            if (nowSize==1){
                nums[0]=0;
                datas[0]=null;
                children[0]=null;
                children[1]=null;
            }else {
                children[where+1]=child;
                for (int i = where; i <nowSize; i++) {
                    if (i!=(nowSize-1)){
                        nums[i]=nums[i+1];
                        datas[i]=datas[i+1];
                        children[i]=children[i+1];
                    }else {
                        nums[i]=0;
                        datas[i]=null;
                        children[i]=children[i+1];
                    }
                }
            }
            nowSize--;
        }
    }

    public static void main(String[] args) {

    }


    public static void createBTree(){
        Node firstNode=new Node(null,null,-1,Node.maxNodeNum);
        Root.root=firstNode;
    }

    public static void insertBTree(Node nowRoot,int i,Object data){
        int where=0;
        for (int j = 0; j < nowRoot.nowSize; j++) {
            if (nowRoot.nums[j]>i){
                where=j;
                break;
            }else {
                where=j+1;
            }
        }
        boolean isDivide=false;
        if (nowRoot.nowSize==Node.maxNodeNum){
            divideNode(nowRoot);
            isDivide=true;
        }
        if (isDivide){
//            where=
        }

        if (nowRoot.children[0]==null){
            if (where>(Node.maxNodeNum/2)){

            }else {

            }
        }else {

            Node child=nowRoot.children[where];
            insertBTree(child,i,data);
        }

    }

    public static Node divideNode(Node node){
        int middleNodeNum=Node.maxNodeNum/2;
        Node leftChild=new Node(null,null,-1,Node.maxNodeNum);
        Node rightChild=new Node(leftChild,null,-1,Node.maxNodeNum);
        leftChild.brother=rightChild;

        for (int i = 0; i < middleNodeNum; i++) {
            leftChild.addData(node,i,i);
        }
        int j=0;
        for (int i = middleNodeNum+1; i < Node.maxNodeNum; i++) {
            rightChild.addData(node,i,j);
            j++;
        }

        if (node.parent!=null){
            node.parent.addData(node.nums[middleNodeNum],node.datas[middleNodeNum],leftChild,rightChild,node.leftParentNum+1);
        }else {
            for (int i = 0; i < node.nowSize; i++) {
                if (i!=middleNodeNum){
                    node.deleteData(i,null);
                }
            }

            node.children[middleNodeNum]=leftChild;
            node.children[middleNodeNum+1]=rightChild;
            leftChild.parent=node;
            rightChild.parent=node;
        }
        return node.parent==null?node:node.parent;
    }

}
