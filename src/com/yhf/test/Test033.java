package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test033 {
    /**
     * 题目0033-最近的点
     * 题目描述
     * 同一个数轴x有两个点的集合A={A1,A2,...,Am}和B={B1,B2,...,Bm}
     * A(i)和B(j)均为正整数
     * A、B已经按照从小到大排好序，A、B均不为空
     * 给定一个距离R正整数，列出同时满足如下条件的
     * (A(i),B(j))数对
     * <p>
     * A(i)<=B(j)
     * A(i),B(j)之间距离小于等于R
     * 在满足1，2的情况下每个A(i)只需输出距离最近的B(j)
     * 输出结果按A(i)从小到大排序
     * 输入描述
     * 第一行三个正整数m n R
     * 第二行m个正整数 表示集合A
     * 第三行n个正整数 表示集合B
     * 输入限制 1 <= R <= 100000
     * 1 <= n, m <= 100000
     * 1 <= A(i), B(j) <= 1000000000
     * <p>
     * 输出描述
     * 每组数对输出一行A(i)和B(j)
     * 以空格隔开
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
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int r = scanner.nextInt();
            int[] collA = new int[n];
            int[] collB = new int[m];
            for (int i = 0; i < n; i++) {
                collA[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                collB[i] = scanner.nextInt();
            }
            solution(r, collA, collB);
        }
    }

    private static void solution(int r, int[] collA, int[] collB) {
        for (int Ai : collA) {
            for (int Bj : collB) {
                if (Ai <= Bj && Bj - Ai <= r) {
                    System.out.println(Ai + " " + Bj);
                    break;
                }
            }
        }
    }
}
