package com.example.IntroductionToAlgorithms.K_红黑树;

import com.example.IntroductionToAlgorithms.util.Util;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
public class B_RedBlackTree {
    public static class RedBlackTreeNode<T extends Comparable>{
        public static final RedBlackTreeNode NIL=new RedBlackTreeNode<>();
        static {
            NIL.parent=NIL;
            NIL.leftChild=NIL;
            NIL.rightChild=NIL;
        }
        T data;
        RedBlackTreeNode<T> parent=NIL;
        RedBlackTreeNode<T> leftChild=NIL;
        RedBlackTreeNode<T> rightChild=NIL;
        boolean isLeft=true;
        boolean isBlack=false;

        public RedBlackTreeNode(T data) {
            this.data = data;
        }

        private RedBlackTreeNode() {}

        public RedBlackTreeNode<T> getChild(boolean isLeft){
            if (this==NIL)return NIL;
            if (isLeft)return leftChild;
            else return rightChild;
        }

        public RedBlackTreeNode<T> getBrother(){
            if (parent==NIL)return NIL;
            if (this==NIL&&parent.leftChild!=NIL){
                return parent.rightChild;
            }else if (this==NIL&&parent.rightChild!=NIL)
                return parent.leftChild;

            if (isLeft)return parent.rightChild;
            else return parent.leftChild;
        }

        public RedBlackTreeNode<T> getGrandParent(){
            if (parent==NIL)return NIL;
            else return parent.parent;
        }
        public void setChild(RedBlackTreeNode<T> child){
            if (this==NIL)return;
            if (child.isLeft)this.leftChild=child;
            else this.rightChild=child;
        }
        public void setParent(RedBlackTreeNode<T> parent){
            if (this==NIL)return;
            this.parent=parent;
        }
    }

    public static void main(String[] args) {
        int[] ints= Util.getRandomIntListHasBounder(10,1000);
        RedBlackTreeNode<Integer> root=new RedBlackTreeNode<>(null);
        for (int i = 0; i < ints.length; i++) {
            root=insert(root,new RedBlackTreeNode<>(new Integer(ints[i])));
        }
    }

    public static <T extends Comparable> RedBlackTreeNode insert(RedBlackTreeNode<T> root,RedBlackTreeNode<T> insertNode){
        /**
         * insert(root,insertNode)
         * if root is NIL
         *      root=insertNode
         *      return
         * nowNode=root
         * while nowNode is not NIL
         *      parentNode=nowNode
         *      if nowNode.data>=leaf.data
         *          nowNode=nowNode.leftChild
         *          insertNode.isLeft=true
         *      else
         *          nowNode=nowNode.rightChild
         *          insertNode.isLeft=false
         *
         * parentNode.setChild(insertNode)
         * insertNode.setParent(parentNode)
         * grandParentNode=parentNode.parent
         * uncleNode=parentNode.getBrother()
         * insertTranslate(grandParentNode,parentNode,uncleNode,insertNode)
         */
        if (root.data==null){
            root.data=insertNode.data;
            return root;
        }
        RedBlackTreeNode<T> nowNode=root,parentNode = null,grandParentNode,uncleNode;
        while (nowNode!=RedBlackTreeNode.NIL){
            parentNode=nowNode;
            if (nowNode.data.compareTo(insertNode.data)==0||nowNode.data.compareTo(insertNode.data)==1){
                nowNode=nowNode.leftChild;
                insertNode.isLeft=true;
            } else{
                nowNode=nowNode.rightChild;
                insertNode.isLeft=false;
            }
        }

        parentNode.setChild(insertNode);
        insertNode.setParent(parentNode);
        grandParentNode=parentNode.parent;
        uncleNode=parentNode.getBrother();
        RedBlackTreeNode<T> tempRoot= insertTranslate(grandParentNode,parentNode,uncleNode,insertNode);
        return tempRoot==null?root:tempRoot;
    }

    public static <T extends Comparable> RedBlackTreeNode delete(RedBlackTreeNode<T> root,T data){
        return null;
    }

    private static <T extends Comparable> RedBlackTreeNode<T> insertTranslate(RedBlackTreeNode<T> grandParentNode, RedBlackTreeNode<T> parentNode, RedBlackTreeNode<T> uncleNode, RedBlackTreeNode<T> insertNode){
        /**
         * if parentNode==NIL
         *      return
         * if parentNode.isBlack
         *      return
         * if grandParentNode==NIL
         *      parentNode.lsBlack=true
         *      return
         * if grandParentNode.isBlack and !parentNode.isBlack and (uncleNode==NIL or uncleNode.isBlack)
         *      if parentNode.isLeft!=insertNode.isLeft
         *          rotate(parentNode,insertNode,parentNode.isLeft)
         *      grandParentNode.isBlack=false
         *      parenNode.isBlack=true
         *      rotate(grandParentNode,parenNode,!parentNode.isLeft)
         *      return
         * if !parentNode.isBlack and grandParentNode.isBlack and !uncleNode.isBlack
         *     parentNode.isBlack=true
         *     uncleNode.isBlack=true
         *     grandParentNode.isBlack=false
         *     tempUncleNode=grandParentNode.parent.getBrother()
         *     insertTranslate(grandParentNode.parent.parent,grandParentNode.parent,tempUncleNode,grandParentNode)
         * return
         */

        //情况一,从情况五中来。表示之前grandParentNode已经是Root节点，此时不需要改变
        if (parentNode==RedBlackTreeNode.NIL)
            return null;
        //情况二，当插入节点的父节点是黑节点的时候，红黑树性质不变
        if (parentNode.isBlack){
            return null;
        }
        //情况三，从情况五中来，表示之前grandParentNode的parentNode已经是Root节点,而之前grandParentNode已经是红节点
        //此时需要将之前grandParentNode的parentNode变成黑节点，因为是Root节点所以不会影响性质
        if (grandParentNode==RedBlackTreeNode.NIL){
            parentNode.isBlack=true;
            return null;
        }
        //情况四，爷、父、叔、子分别为 黑、红、黑、红。此时第一步需要将爷、父、子变成直线。然后旋转爷、父即可变成红、黑、黑、红
        if (grandParentNode.isBlack&&!parentNode.isBlack&&(uncleNode==RedBlackTreeNode.NIL||uncleNode.isBlack)){
            //如果不是直线，那么就旋转成直线
            if (parentNode.isLeft!=insertNode.isLeft)
                rotate(parentNode,insertNode,parentNode.isLeft);
            //将爷、父的颜色交换一下
            grandParentNode.isBlack=false;
            parentNode.isBlack=true;
            //将爷、父旋转
            rotate(grandParentNode,parentNode,!parentNode.isLeft);
            return parentNode.parent==RedBlackTreeNode.NIL?parentNode:null;
        }
        //情况五,在爷、父、叔、子为黑、红、红、红,的情况下只要改为红、黑、黑、红就行，
        // 不过此时会有个问题就是不清楚爷父是什么情况，所以需要将爷当成插入的子进行递归。
        if (grandParentNode.isBlack&&!parentNode.isBlack&&!uncleNode.isBlack){
            parentNode.isBlack=true;
            uncleNode.isBlack=true;
            grandParentNode.isBlack=false;

            RedBlackTreeNode<T> tempGrandParent,tempParent,tempUncleNode;
            tempGrandParent=grandParentNode.getGrandParent();
            tempParent=grandParentNode.parent;
            tempUncleNode=tempParent.getBrother();
            return insertTranslate(tempGrandParent,tempParent,tempUncleNode,grandParentNode);
        }
        return null;
    }

    private static <T extends Comparable> RedBlackTreeNode rotate(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> childNote,boolean isLeft){
        if (isLeft)return leftRotate(parentNode,childNote);
        else return rightRotate(parentNode,childNote);
    }

    private static <T extends Comparable> RedBlackTreeNode rightRotate(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> rightNode){
        replaceNode(parentNode,rightNode.rightChild,parentNode.leftChild,true);
        replaceNode(parentNode.parent,rightNode,parentNode,true);
        replaceNode(rightNode,parentNode,rightNode.rightChild,false);
        return rightNode;
    }

    private static <T extends Comparable> RedBlackTreeNode leftRotate(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> leftNode){
        replaceNode(parentNode,leftNode.leftChild,parentNode.rightChild,false);
        replaceNode(parentNode.parent,leftNode,parentNode,true);
        replaceNode(leftNode,parentNode,leftNode.leftChild,true);
        return leftNode;
    }

    private static <T extends Comparable> RedBlackTreeNode replaceNode(RedBlackTreeNode<T> parentNode,RedBlackTreeNode<T> nodeReplace,RedBlackTreeNode<T> nodeBeReplace,boolean beReplaceIsLeft){
        if (parentNode!=RedBlackTreeNode.NIL){
            if (nodeReplace!=RedBlackTreeNode.NIL&&nodeReplace.parent!=RedBlackTreeNode.NIL){
                if (nodeReplace.isLeft)nodeReplace.parent.leftChild=RedBlackTreeNode.NIL;
                else nodeReplace.parent.rightChild=RedBlackTreeNode.NIL;
            }
            if ((nodeBeReplace!=RedBlackTreeNode.NIL&&nodeBeReplace.isLeft)||(nodeBeReplace==RedBlackTreeNode.NIL&&beReplaceIsLeft)){
                parentNode.leftChild=nodeReplace;
                nodeReplace.isLeft=true;
            } else if ((nodeBeReplace!=RedBlackTreeNode.NIL&&!nodeBeReplace.isLeft)||(nodeBeReplace==RedBlackTreeNode.NIL&&!beReplaceIsLeft)){
                parentNode.rightChild=nodeReplace;
                nodeReplace.isLeft=false;
            }
            if (nodeReplace!=RedBlackTreeNode.NIL)nodeReplace.parent=parentNode;
            if (nodeBeReplace!=RedBlackTreeNode.NIL)nodeBeReplace.parent=RedBlackTreeNode.NIL;
        }
        return nodeReplace;
    }
}
