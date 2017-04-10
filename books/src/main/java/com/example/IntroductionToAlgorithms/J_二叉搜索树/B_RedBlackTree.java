package com.example.IntroductionToAlgorithms.J_二叉搜索树;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class B_RedBlackTree {
    public static class RedBlackTreeNode<T extends Comparable>{
        public static final RedBlackTreeNode NIL=new RedBlackTreeNode<>();
        T data;
        RedBlackTreeNode<T> parent;
        RedBlackTreeNode<T> leftChild;
        RedBlackTreeNode<T> rightChild;
        boolean isBlack=true;

        public RedBlackTreeNode(T data) {
            this.data = data;
            this.leftChild=NIL;
            this.rightChild=NIL;
            this.parent=NIL;
        }

        private RedBlackTreeNode() {}
    }

    public static void main(String[] args) {

    }

    private static <T extends Comparable> RedBlackTreeNode leftRotate(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> leftNode){
        replaceNode(parentNode,leftNode.rightChild,parentNode.leftChild);
        replaceNode(parentNode.parent,leftNode,parentNode);
        replaceNode(leftNode,parentNode,leftNode.rightChild);
        return
    }

    private static <T extends Comparable> RedBlackTreeNode replaceNode(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> nodeReplace,RedBlackTreeNode<T> nodeBeReplace){
        if (parentNode==RedBlackTreeNode.NIL)return nodeReplace;
        if (parentNode.leftChild==nodeBeReplace)
            parentNode.leftChild=nodeReplace;
        else if(parentNode.rightChild==nodeBeReplace&&parentNode.leftChild!=parentNode.rightChild)
            parentNode.rightChild=nodeReplace;
        if (nodeReplace!=null)nodeReplace.parent=parentNode;
        return nodeReplace;
    }
}
