package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test088 {
    /**
     * 题目0088-寻找连续区间
     * 题目描述
     * 给定一个含有N个正整数的数组，
     * 求出有多少个连续区间（包括单个正整数），
     * 它们的和大于等于x。
     * <p>
     * 输入描述
     * 第一行两个整数N x (0 < N <= 100000 ,0 <= x <= 10000000)
     * 第二行有N个正整数（每个正整数小于等于100）。
     * <p>
     * 输出描述
     * 输出一个整数，表示所求的个数。
     * <p>
     * 示例一
     * 输入
     * 3 7
     * 3 4 7
     * 输出
     * 4
     * 说明
     * 3+4 4+7 3+4+7 7这四组数据都是大于等于7的，所以答案为4
     * <p>
     * 示例二
     * 输入
     * 10 10000000
     * 1 2 3 4 5 6 7 8 9 10
     * 输出
     * 0
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            solution(line1, line2);
        }
    }

    private static void solution(String line1, String line2) {
        String[] split = line1.split(" ");
        int n = Integer.parseInt(split[0]);
        int x = Integer.parseInt(split[1]);
        String[] numStrs = line2.split(" ");
        int[] ints = new int[n];
        for (int i = 0; i < numStrs.length; i++) {
            ints[i] = Integer.parseInt(numStrs[i]);
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                if (sum(ints, i, j) >= x) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int sum(int[] ints, int i, int j) {
        int sum = 0;
        for (int k = i; k < j + 1; k++) {
            sum += ints[k];
        }
        return sum;
    }
}
