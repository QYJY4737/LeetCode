package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test139 {
    /**
     * 题目0139-判断牌型
     * 题目描述
     * 五张牌每张牌由牌大小和花色组成
     * 牌大小2~10 J Q K A
     * 花色四种 红桃 黑桃 梅花 方块 四种花色之一
     *
     * 判断牌型
     * 牌型一 同花顺
     * 同一花色的顺子 如红桃2红桃3红桃4红桃5红桃6
     * 牌型二 四条
     * 四张相同数字+单张 红桃A 黑桃A 梅花A 方块A 加黑桃A
     * 牌型三 葫芦
     * 三张相同数字加一对
     * 如 红桃5 黑桃5 梅花5 加方块9 梅花9
     * 牌型四 同花
     * 同一种花色
     * 如方块3 方块7 方块10 方块J
     * 牌型五 顺子
     * 花色不一样的顺子
     * 如红桃2 黑桃3 红桃4 红桃5 方块6
     * 牌型六 三条
     * 三张相同 + 两张单
     * 牌型七 其他
     * 输入描述
     * 输入由5行组成
     * 每行为一张牌大小和花色
     * 牌大小为 2~10 J Q K A
     * 花色分别用字符 H S C D表示红桃 黑桃 梅花 方块
     *
     * 输出描述
     * 输出牌型序号
     * 五张牌符合多种牌型时，取最大的牌型序号输出
     * 五张牌中不会出现数字大小和花色完全相同的牌
     * 编号小的牌型较大，包含A的合法顺子只有 10 J Q K A 、 A 2 3 4 5
     * 类似 KA234不是合法顺子
     *
     * 示例一
     * 输入
     * 4 H
     * 5 S
     * 6 C
     * 7 D
     * 8 D
     * 输出
     * 5
     * 说明
     * 示例二
     * 输入
     * 9 S
     * 5 S
     * 6 S
     * 7 S
     * 8 S
     * 输出
     * 1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] poker = new String[5];
            for (int i = 0; i < poker.length; i++) {
                poker[i] = scanner.nextLine();
            }

            solution(poker);

        }
    }

    private static void solution(String[] poker) {
        List<Integer> list = new ArrayList<>();
        int[] number = new int[5];
        String[] type = new String[5];
        for (int i = 0; i < number.length; i++) {
            String[] split = poker[i].split(" ");
            String temp = split[0];
            type[i] = split[1];
            switch (temp) {
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                default:
                    number[i] = Integer.parseInt(temp);
                    break;
            }

        }

        // 错误牌型
        for (String s : type) {
            if (!"HSCD".contains(s)) {
                System.out.println(7);
                return;
            }
        }
        Arrays.sort(number);

        boolean flag = false;
        if (type[0].equals(type[1]) &&
                type[1].equals(type[2]) &&
                type[2].equals(type[3]) &&
                type[3].equals(type[4])) {
            flag = true;
            list.add(4);
        }

        int len = 1;
        for (int i = 0; i < number.length - 1; i++) {
            if (number[i + 1] - number[i] == 1) {
                len++;
            }
        }
        int e1cnt = 1;
        int e2cnt = 1;

        for (int i = 0; i < number.length - 1; i++) {
            if (number[i + 1] == number[i]) {
                e1cnt++;
            } else if (number[i + 1] != number[i]) {
                for (int j = i + 1; j < number.length - 1; j++) {
                    if (number[j + 1] == number[j]) {
                        e2cnt++;
                    }
                }
                break;
            }
        }
        if (len == 5 && flag) {
            list.add(1);
        } else if ((e1cnt == 4 || e2cnt == 4) && !flag) {
            list.add(2);
        } else if ((e1cnt == 3 && e2cnt == 2) || ((e1cnt == 2 && e2cnt == 3)) && !flag) {
            list.add(3);
        } else if (len == 5) {
            list.add(5);
        } else if ((e1cnt == 3 && e2cnt == 1) || ((e1cnt == 1 && e2cnt == 3)) && !flag) {
            list.add(6);
        } else {
            list.add(7);
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
