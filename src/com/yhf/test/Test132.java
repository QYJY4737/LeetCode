package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test132 {
    /**
     * 题目0132-事件推送
     * 题目描述
     * 同一个数轴X上有两个点的集合A={A1, A2, …, Am}和B={B1, B2, …, Bn}，
     * Ai和Bj均为正整数，A、B已经按照从小到大排好序，A、B均不为空，
     * 给定一个距离R(正整数)，
     * 列出同时满足如下条件的所有（Ai, Bj）数对：
     * <p>
     * Ai <= Bj
     * Ai, Bj之间的距离小于等于R
     * 在满足1,2的情况下，每个Ai只需输出距离最近的Bj
     * 输出结果按Ai从小到大的顺序排序
     * 输入描述
     * 第一行三个正整数m，n，R
     * 第二行m个正整数，表示集合A
     * 第三行n个正整数，表示集合B
     * 输入限制：
     * 1 <= R <= 100000，1 <= n,m <= 100000，1 <= Ai,Bj <= 1000000000
     * <p>
     * 输出描述
     * 每组数对输出一行Ai和Bj，以空格隔开
     * <p>
     * 示例一
     * 输入
     * 4 5 5
     * 1 5 5 10
     * 1 3 8 8 20
     * 输出
     * 1 1
     * 5 8
     * 5 8
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int R = scanner.nextInt();
            int[] a = new int[m];
            int[] b = new int[n];

            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            solution(R, a, b);
        }
    }

    private static void solution(int R, int[] a, int[] b) {
        int index = 0;
        List<int[]> list = new ArrayList<>();

        for (int j : a) {

            int[] ints = new int[2];

            while (index < b.length) {
                if (j <= b[index] && b[index] - j <= R) {
                    ints[0] = j;
                    ints[1] = b[index];
                    list.add(ints);
                    break;
                }
                index++;
            }
        }

        list.forEach(e -> System.out.print(e[0] + " " + e[1]));
    }
}
