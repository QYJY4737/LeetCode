package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test117 {
    /**
     * 题目0117-斗地主2
     * 题目描述
     * 在斗地主扑克牌游戏中，扑克牌由小到大的顺序为3 4 5 6 7 8 9 10 J Q K A 2
     * 玩家可以出的扑克牌阵型有，单张，对子，顺子，飞机，炸弹等
     * 其中顺子的出牌规则为，由至少5张由小到大连续递增的扑克牌组成
     * 且不能包含2
     * 例如:{3,4,5,6,7}、{3,4,5,6,7,8,9,10,J,Q,K,A}都是有效的顺子
     * 而{J,Q,K,A,2}、{2,3,4,5,6}、{3,4,5,6}、{3,4,5,6,8}等都不是顺子
     * 给定一个包含13张牌的数组，如果有满足出牌规则的顺子，请输出顺子
     * 如果存在多个顺子，请每行输出一个顺子
     * 且需要按照顺子的第一张牌的大小(必须从小到大)依次输出
     * 如果没有满足出牌规则的顺子，请输出No
     *
     * 输入描述
     * 13张任意顺序的扑克牌，每张扑克牌数字用空格隔开，
     * 每张扑克牌的数字都是合法的
     * 并且不包括大小王：2 9 J 2 3 4 K A 7 9 A 5 6
     * 不需要考虑输入为异常字符的情况
     *
     * 输出描述
     * 组成的顺子 每张扑克牌数字用空格隔开
     * 3 4 5 6 7
     *
     * 示例一
     * 输入
     * 2 9 J 2 3 4 K A 7 9 A 5 6
     * 输出
     * 3 4 5 6 7
     * 说明
     * 13张牌中可以组成的顺子只有一组：3 4 5 6 7
     *
     * 示例二
     * 输入
     * 2 9 J 10 3 4 K A 7 Q A 5 6
     * 输出
     * 3 4 5 6 7
     * 9 10 J Q K A
     * 说明
     * 13张牌中可以组成两组顺子，从小到大分别为：
     * 3 4 5 6 7
     * 9 10 J Q K A
     *
     * 示例三
     * 输入
     * 2 9 9 9 3 4 K A 10 Q A 5 6
     * 输出
     * No
     * 说明
     * 13张牌中无法组成顺子
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        String[] index = new String[13];
        convert(split, index);

        List<String> resSet = new LinkedList<>();
        for (int i = 1; i < index.length; i++) {
            int count = 0;
            StringBuilder builder = new StringBuilder();
            while (i < index.length && index[i] != null) {
                builder.append(index[i]).append(" ");
                count++;
                i++;
            }
            if (count >= 5) {
                resSet.add(builder.substring(0, builder.length() - 1));
            }
        }

        if (resSet.size() == 0) {
            System.out.println("No");
        } else {
            for (String res : resSet) {
                System.out.println(res);
            }
        }

    }

    private static void convert(String[] split, String[] ints) {
        for (String str : split) {
            if (str.length() == 1) {
                char c = str.charAt(0);
                if (Character.isDigit(c)) {
                    ints[Character.digit(c, 10) - 2] = str;
                } else {
                    switch (c) {
                        case 'A':
                            ints[12] = str;
                            break;
                        case 'J':
                            ints[9] = str;
                            break;
                        case 'Q':
                            ints[10] = str;
                            break;
                        case 'K':
                            ints[11] = str;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                ints[8] = str;
            }
        }
    }
}
