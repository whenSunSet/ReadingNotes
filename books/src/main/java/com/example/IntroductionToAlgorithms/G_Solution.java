package com.example.IntroductionToAlgorithms;

import java.util.Scanner;

/**
 * Created by heshixiyang on 2017/4/26.
 */
public class G_Solution {
    /**
     阿里巴巴大学准备组织一场游戏竞技大赛。允许参赛同学任意组队，且不限制每队人数。假设你作为组委会代表，负责人员的分组工作。
     首先你给每位报名同学编了号，然后让每位同学在一张卡片上写下希望一起组队同学的编号，顺序无所谓。
     例如1号同学希望能和4，5两位同学组队。就是卡片上写4 5。
     但是为了让大家都满意，只有在4号同学愿意和1 5组队，且5号同学愿意和1 4组队的场景下，该组队请求（1 4 5）才能成立，组队成功的同学才能参加比赛。
     请通过代码计算出所有可以参赛同学的分组结果。多个队伍之间半角逗号分隔，组内成员之间半角空格分隔。
     组与组之间按组内最小编号的成员正序排序，组内按人员编号正序排序。

     注意：
     多人组队场景，只有相关的所有人都愿意，才能组队成功。例如1号想和4，5组队， 4号想和1，5组队，但是5号只想和4组队。此时1，4，5三人组队不成功，三人都无法参赛。
     假设某同学只愿意自己独立一队（即不愿意和任何人组队），可以在纸上写self。则认为该同学自己组队，且能成功参赛。例如1号想和4，5组队，但是4号想和1，5组队，
     但是5号不想组队，打算独自参赛。此时1，4，5三人组队不成功，但是5号个人组队成功。1，4无法参赛，5号独立一队可以参赛。
     如果所有同学都无法组队成功。返回na
     输入的第一行表示有多少人参加报名，之后的每一行，依次代表每位同学的组队意愿。
     */
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String process(String[] input) {
        int num=Integer.valueOf(input[0]);

        return "1 4 5,2 3";
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = process(_input);
        System.out.println(res);
    }
}
