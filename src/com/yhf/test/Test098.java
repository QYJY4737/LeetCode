package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test098 {
    /**
     * 题目0098-篮球比赛
     * 题目描述
     * 篮球（5v5）比赛中每个球员拥有一个战斗力，
     * 每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
     * 现有十个球员准备分为两队进行训练赛，
     * 教练希望两个队伍的战斗力差能够尽可能的小，以达到最佳训练效果。
     * 给出十个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果？
     * 请输出该分队方案下的最小战斗力差值。
     *
     * 输入描述
     * 十个篮球队员的战斗力（整数，范围[1，10000]），战斗力之间用空格分隔，
     * 如：10 9 8 7 6 5 4 3 2 1
     * 不需要考虑异常输入的场景
     *
     * 输出描述
     * 最小战斗力差值，
     * 如：1
     *
     * 示例一
     * 输入
     * 10 9 8 7 6 5 4 3 2 1
     * 输出
     * 1
     * 说明
     * 1 2 5 9 10 分为一队，3 4 6 7 8 分为一队，两队战斗力之差最小，输出差值1。
     *
     * 备注
     * 球员分队方案不唯一，但最小战斗力差值固定是1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");

        List<Integer> ints = new LinkedList<>();
        for (String s : split) {
            ints.add(Integer.parseInt(s));
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            List<Integer> tmp = new LinkedList<>(ints);
            int x = 0, y = 0;
            for (int j = 0; j < 5; j++) {
                x += tmp.remove(random.nextInt(tmp.size()));
                y += tmp.remove(random.nextInt(tmp.size()));
            }
            int diff = Math.abs(x - y);
            if (diff < min) {
                min = diff;
            }
        }

        System.out.println(min);
    }
}
