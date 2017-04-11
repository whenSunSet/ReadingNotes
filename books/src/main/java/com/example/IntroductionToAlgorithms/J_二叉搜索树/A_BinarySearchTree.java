package com.example.IntroductionToAlgorithms.J_二叉搜索树;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class A_BinarySearchTree {
    public static class TreeNode<T extends Comparable>{
        public TreeNode parent;
        public TreeNode leftChild;
        public TreeNode rightChild;
        public T data;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] ints= Util.getRandomIntListHasBounder(10,100);
        TreeNode root=new TreeNode(null);
        System.out.println("建立树");
        for (int i = 0; i < ints.length; i++) {
            insertNode(root,new TreeNode(new Integer(ints[i])));
        }
        System.out.println("先序遍历");
        preOrderTraversal(root);
        System.out.println("中序遍历");
        inorderTraversal(root);
        System.out.println("后序遍历");
        postOrderTraversal(root);
        System.out.println("查找58");
        System.out.println(searchNode(root, new Integer(58)).data);
        System.out.println("删除7，测试第一种删除情况");
        root=deleteNode(root,new Integer(7));
        System.out.println("删除0，测试第二种删除情况");
        root=deleteNode(root,new Integer(0));
        System.out.println("删除29，测试第三种删除情况");
        root=deleteNode(root,new Integer(29));
        System.out.println("删除58，测试第五种删除情况");
        root=deleteNode(root,new Integer(58));
    }

    public static void insertNode(TreeNode root,TreeNode leaf){
        /**
         * insertNode(root,leaf)
         * if root is null
         *      root=leaf
         *      return
         * nowNode=root
         * while nowNode is not null
         *      parentNode=nowNode
         *      if nowNode.data>=leaf.data
         *          nowNode=nowNode.leftChild
         *      else
         *          nowNode=nowNode.rightChild
         * if parentNode.data>=leaf.data
         *      parentNode.leftChild=leaf
         *      parentNode.leftChild.parent=parentNode
         * else
         *      parentNode.rightChild=leaf
         *      parentNode.rightChild.parent=parentNode
         */
        if (root.data==null){
            root.data=leaf.data;
            return;
        }
        TreeNode nowNode=root,parentNode=null;
        while (nowNode!=null){
            parentNode=nowNode;
            if (nowNode.data.compareTo(leaf.data)==0||nowNode.data.compareTo(leaf.data)==1)
                nowNode=nowNode.leftChild;
            else
                nowNode=nowNode.rightChild;
        }
        if (parentNode.data.compareTo(leaf.data)==0||parentNode.data.compareTo(leaf.data)==1){
            parentNode.leftChild=leaf;
            parentNode.leftChild.parent=parentNode;
        } else{
            parentNode.rightChild=leaf;
            parentNode.rightChild.parent=parentNode;
        }
    }

    public static <T extends Comparable> TreeNode deleteNode(TreeNode<T> root,T data){
        /**
         * deleteNode(root,data)
         * deleteNode=searchNode(root,data)
         * if deleteNode is null
         *      return false
         * if deleteNode.leftChild is null and deleteNode.rightChild is null
         *      delete deleteNode
         * else if deleteNode.leftChild is null and deleteNode.rightChild is not null
         *      deleteNode.rightChild replace deleteNode
         * else if deleteNode.leftChild is not null and deleteNode.rightChild is null
         *      deleteNode.leftChild replace deleteNode
         * else
         *      if deleteNode.rightChild.leftChild is null
         *          deleteNode.leftChild replace deleteNode.rightChild.leftChild
         *          deleteNode.rightChild replace deleteNode
         *      else
         *          tempNode=deleteNode.rightChild.leftChild
         *          while tempNode.leftChild is not null
         *              tempNode=tempNode.leftChild
         *          deleteNode.leftChild replace tempNode.leftChild
         *          tempNode.rightChild replace tempNode.parent.leftChild
         *          deleteNode.rightChild replace tempNode.rightChild
         *          tempNode replace deleteNode
         */
        TreeNode deleteNode=searchNode(root,data),nowRoot;
        if (deleteNode==null)return root;
        if (deleteNode.leftChild==null&&deleteNode.rightChild==null){
            nowRoot=replaceNode(deleteNode.parent,null,deleteNode);
        }else if (deleteNode.leftChild==null&&deleteNode.rightChild!=null){
            nowRoot=replaceNode(deleteNode.parent,deleteNode.rightChild,deleteNode);
        }else if (deleteNode.leftChild!=null&&deleteNode.rightChild==null){
            nowRoot=replaceNode(deleteNode.parent,deleteNode.leftChild,deleteNode);
        }else {
            if (deleteNode.rightChild.leftChild==null){
                replaceNode(deleteNode.rightChild,deleteNode.leftChild,deleteNode.rightChild.leftChild);
                nowRoot=replaceNode(deleteNode.parent,deleteNode.rightChild,deleteNode);
            }else {
                TreeNode tempNode=deleteNode.rightChild.leftChild;
                while (tempNode.leftChild!=null)
                    tempNode=tempNode.leftChild;
                replaceNode(tempNode,deleteNode.leftChild,tempNode.leftChild);
                replaceNode(tempNode.parent,tempNode.rightChild,tempNode.parent.leftChild);
                replaceNode(tempNode,deleteNode.rightChild,tempNode.rightChild);
                nowRoot=replaceNode(deleteNode.parent,tempNode,deleteNode);
            }
        }
        return nowRoot.parent==null?nowRoot:root;
    }

    private static <T extends Comparable> TreeNode replaceNode(TreeNode<T> parentNode,TreeNode<T> nodeReplace,TreeNode<T> nodeBeReplace){
        if (parentNode!=null){
            if (nodeReplace!=null){
                if (nodeReplace.parent!=null&&nodeReplace.parent.leftChild==nodeReplace)nodeReplace.parent.leftChild=null;
                if (nodeReplace.parent!=null&&nodeReplace.parent.rightChild==nodeReplace)nodeReplace.parent.rightChild=null;
            }
            if (parentNode.leftChild==nodeBeReplace){
                parentNode.leftChild=nodeReplace;
            } else if (parentNode.rightChild==nodeBeReplace&&parentNode.rightChild!=parentNode.leftChild){
                parentNode.rightChild=nodeReplace;
            }
            if (nodeReplace!=null)nodeReplace.parent=parentNode;
            if (nodeBeReplace!=null)nodeBeReplace.parent=null;
        }
        return nodeReplace;
    }

    public static <T extends Comparable> TreeNode searchNode(TreeNode<T> root,T data){
        if (root==null)return null;
        if (root.data.compareTo(data)==0) return root;
        else if (root.data.compareTo(data)==1)return searchNode(root.leftChild,data);
        else if (root.data.compareTo(data)==-1)return searchNode(root.rightChild,data);
        return null;
    }

    public static void preOrderTraversal(TreeNode root){
        if (root==null)return;
        else System.out.println(root.data);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }
    public static void inorderTraversal(TreeNode root){
        if (root==null)return;
        inorderTraversal(root.leftChild);
        System.out.println(root.data);
        inorderTraversal(root.rightChild);
    }
    public static void postOrderTraversal(TreeNode root){
        if (root==null)return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.data);
    }
}
