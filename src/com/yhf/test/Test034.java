package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test034 {
    /**
     * 题目0034-能力组队
     * 题目描述
     * 用数组代表每个人的能力，
     * 一个比赛活动要求，参赛团队的最低能力值为N
     * 每个团队可以由一人或者两人组成，
     * 且一个人只能参加一个团队，
     * 计算出最多可以派出多少只符合要求的队伍。
     * <p>
     * 输入描述
     * 第一行代表总人数，范围1 ~ 500000
     * 第二行数组代表每个人的能力
     * 数组大小范围1 ~ 500000
     * 元素取值范围1 ~ 500000
     * 第三行数值为团队要求的最低能力值1 ~ 500000
     * <p>
     * 输出描述
     * 最多可以派出的团队数量
     * <p>
     * 示例一
     * 输入
     * 5
     * 3 1 5 7 9
     * 8
     * 输出
     * 3
     * 说明
     * 3、5组成一队
     * 1、7一队
     * 9自己一队
     * 输出3
     * <p>
     * 示例二
     * 输入
     * 7
     * 3 1 5 7 9 2 6
     * 8
     * 输出
     * 4
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            int base = scanner.nextInt();
            solution(n, ints, base);
        }
    }

    private static void solution(int n, int[] ints, int base) {
        int[] arr = Arrays.stream(ints)
                .filter(x -> x < base)
                .sorted()
                .toArray();
        int count = ints.length - arr.length;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] >= base) {
                count++;
                i++;
                j--;
            } else {
                i++;
            }
        }
        System.out.print(count);
    }
}
