package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test253 {
    /**
     * 题目0253-跳房子I
     * 题目描述
     * 跳房子，也叫跳飞机，是一种世界性的儿童游戏。
     * <p>
     * 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格。
     * <p>
     * 跳房子的过程中，可以向前跳，也可以向后跳。
     * <p>
     * 假设房子的总格数是 countcountcount ，小红每回合可能连续跳的步教都放在数组 stepsstepssteps 中，请问数组中是否有一种步数的组合，可以让小红两个回合跳到量后一格?
     * <p>
     * 如果有，请输出索引和最小的步数组合。
     * 注意：
     * <p>
     * 数组中的步数可以重复，但数组中的元素不能重复使用。
     * 提供的数据保证存在满足题目要求的组合，且索引和最小的步数组合是唯一的。
     * <p>
     * 输入描述
     * 第一行输入为房子总格数 countcountcount，它是 int 整数类型。
     * 第二行输入为每回合可能连续跳的步数，它是 int 整数数组类型。
     * <p>
     * 输出描述
     * 返回索引和最小的满足要求的步数组合（顺序保持steps中原有顺序）
     * <p>
     * 备注
     * count≤1000count \leq 1000count≤1000
     * 0≤steps.length≤50000 \leq steps.length \leq 50000≤steps.length≤5000
     * −100000000≤steps≤100000000-100000000 \leq steps \leq 100000000−100000000≤steps≤100000000
     * <p>
     * 示例一
     * 输入
     * [1,4,5,2,2]
     * 7
     * 输出
     * [5, 2]
     * 说明
     * 示例二
     * 输入
     * [-1,2,4,9,6]
     * 8
     * 输出
     * [-1, 9]
     * 说明
     * 此样例有多种组合满足两回合跳到最后，譬如：[-1,9]，[2,6]，其中[-1,9]的索引和为0+3=3，[2,6]的索和为1+4=5，所以索引和最小的步数组合[-1,9]
     * <p>
     * ¶思路解析和复杂度分析
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line == null || line.length() == 0) {
            System.out.println("0");
            return;
        }
        String[] strs = line.trim().substring(1, line.length() - 1).split(",");
        int[] steps = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            steps[i] = Integer.parseInt(strs[i]);
        }
        int count = sc.nextInt();
        int[] res = solution(count, steps);
        System.out.println(Arrays.toString(res));
    }

    private static int[] solution(int count, int[] steps) {
        int minIndexSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < steps.length; i++) {
            for (int j = i + 1; j < steps.length; j++) {
                if (steps[i] + steps[j] == count && i + j < minIndexSum) {
                    minIndexSum = i + j;
                    result[0] = steps[i];
                    result[1] = steps[j];
                }
                if (steps[i] + steps[j] > count) {
                    break;
                }
            }
        }
        return result;
    }
}
