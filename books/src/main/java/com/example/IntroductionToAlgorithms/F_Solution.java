package com.example.IntroductionToAlgorithms;

import java.util.Scanner;

/**
 * Created by heshixiyang on 2017/4/26.
 */
public class F_Solution {
    /**
     * 你和小x两人都是扑克高手，自从通杀了各大棋牌平台后，决定自己创立一种新的扑克玩法。
     有以下几点规则：
     这种玩法没有大小鬼，没有黑桃。只有红桃、方片、梅花，每种13张。供39张牌。
     两个人玩，每人手上的牌随机，可能是1张，也可能是38张。
     出牌有3种方法，单张，一对（两张大小一样，花色不同，例如44），三张（三张大小一样，花色不同。例如333）。
     顺序3最小、2最大，只能大牌压小牌，花色不影响，张数必须一致。且优先出最小的组合。例如，你手上有6699KK，对方出了33，你应该出66。
     每轮双方必须出牌。碰到手上牌都压不住对方的时候，可以出自己手上最小，且张数最多的组合。例如，你手上有344555，对方出了个6。这时你可以出555
     总是优先出张数匹配的牌，如果出现必须拆牌的情况，优先拆数字小的牌。例1，你手上有3888KK，对方出个6，这时你应该出8。例2，手上有388KKK，对方出JJ,你应该出KK。例3，手上有3QQQKKK，对方出JJ,你应该出QQ。
     * @param args
     */
    /** 请完成下面这个函数，实现题目要求的功能 **/

    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    public static class Card{
        int num;
        char card;

        public Card(int num, char card) {
            this.num = num;
            this.card = card;
        }
    }

    static String process(String pocket, String card) {

        char[] c=pocket.toCharArray();
        Card[] cards=new Card[c.length];
        makeCards(cards,c);
        quickSort(0,cards.length-1,cards);

        if (card.length()==1){
            String r=returnOne(card,cards);
            if (r==null)r=returnNull(cards);
            return r;
        }else if (card.length()==2){
            String r=returnTwo(card,cards);
            if (r==null)r=returnNull(cards);
            return r;
        }else if (card.length()==3){
            String r=returnThree(card,cards);
            if (r==null)r=returnNull(cards);
            return r;
        }
        return null;
    }

    static String  returnOne(String card,Card[] cards){
        Card one=makeCard(card.toCharArray()[0]);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].num>one.num)return cards[i].card+"";
        }
        return null;
    }

    static String  returnTwo(String card,Card[] cards){
        Card one=makeCard(card.toCharArray()[0]);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].num>one.num){
                if (i==cards.length-1)return null;
                if (cards[i+1].num==cards[i].num)return cards[i].card+""+cards[i].card;
            }
        }
        return null;
    }

    static String  returnThree(String card,Card[] cards){
        Card one=makeCard(card.toCharArray()[0]);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].num>one.num){
                if (i==cards.length-1)return null;
                if (i==cards.length-2)return null;
                if (cards[i+1].num==cards[i].num&&cards[i+2].num==cards[i].num)return cards[i].card+""+cards[i].card+""+cards[i].card;
            }
        }
        return null;
    }

    static String returnNull(Card[] cards){
        int num=14,size=0,tempSize=0,tempNum=14;
        char cc='a';
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].num!=tempNum){
                if (tempSize>size){
                    size=tempSize;
                    num=tempNum;
                    if (i!=0)cc=cards[i-1].card;
                }else if (tempSize==size&&tempNum<num){
                    num=tempNum;
                    if (i!=0)cc=cards[i-1].card;
                }
                tempSize=1;
                tempNum=cards[i].num;
            }else {
                tempSize++;
                if (tempSize>size){
                    size=tempSize;
                    num=tempNum;
                    if (i!=0)cc=cards[i-1].card;
                }else if (tempSize==size&&tempNum<num){
                    num=tempNum;
                    if (i!=0)cc=cards[i-1].card;
                }
            }
        }

        String c="";
        for (int i = 0; i < size; i++) {
            c=c+cc+"";
        }
        return c;
    }

    static void makeCards(Card[] cards, char[] c){
        for (int i = 0; i < c.length; i++) {
           cards[i]=makeCard(c[i]);
        }
    }

    static Card makeCard(char c){
        Card card=null;
        switch (c){
            case 'A':
                card=new Card(12,c);
                break;
            case '2':
                card=new Card(13,c);
                break;
            case '3':
                card=new Card(1,c);
                break;
            case '4':
                card=new Card(2,c);
                break;
            case '5':
                card=new Card(3,c);
                break;
            case '6':
                card=new Card(4,c);
                break;
            case '7':
                card=new Card(5,c);
                break;
            case '8':
                card=new Card(6,c);
                break;
            case '9':
                card=new Card(7,c);
                break;
            case '0':
                card=new Card(8,c);
                break;
            case 'J':
                card=new Card(9,c);
                break;
            case 'Q':
                card=new Card(10,c);
                break;
            case 'K':
                card=new Card(11,c);
                break;
        }
        return card;
    }
    public static void quickSort(int start,int end,Card[] cards){
        int[] A=new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            A[i]=cards[i].num;
        }
        if (start<end){
            int middle=partition(A,start,end,cards);
            quickSort(start,middle-1,cards);
            quickSort(middle+1,end,cards);
        }
    }

    public static int partition(int[] A,int start,int end,Card[] cards){
        /**
         * partition(A,start,end)
         * x=A[end]
         * j=start-1
         * for i=start to end-1
         *      if A[i]<=x
         *          j++
         *          exchange A[j] with A[i]
         * exchange A[j+1] with A[end]
         * return j+1
         */

        int x=A[end],j=start-1;
        for (int i = start; i <end; i++) {
            if (A[i]<=x){
                j++;
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;

                Card card=cards[j];
                cards[j]=cards[i];
                cards[i]=card;
            }
        }
        int temp=A[j+1];
        A[j+1]=A[end];
        A[end]=temp;

        Card card=cards[j+1];
        cards[j+1]=cards[end];
        cards[end]=card;

        return j+1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _pocket;
        try {
            _pocket = in.nextLine();
        } catch (Exception e) {
            _pocket = null;
        }

        String _card;
        try {
            _card = in.nextLine();
        } catch (Exception e) {
            _card = null;
        }

        res = process(_pocket, _card);
        System.out.println(res);
    }
}
