package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test076 {
    /**
     * 题目0076-求解连续数列
     * 题目描述
     * 已知连续正整数数列{K}=K1,K2,K3… Ki的各个数相加之和为S,
     * i = N (0 < S < 100000, 0 < N < 100000), 求此数列K。
     * <p>
     * 输入描述
     * 输入包含两个参数
     * <p>
     * 连续正整数数列和S
     * 数列里数的个数N
     * 输出描述
     * 如果有解输出数列K，如果无解输出-1
     * <p>
     * 示例一
     * 输入
     * 525 6
     * 输出
     * 85 86 87 88 89 90
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int s = scanner.nextInt();
            int n = scanner.nextInt();
            solution(s, n);
        }
    }

    private static void solution(int s, int n) {
        int num;
        List<Integer> list = new ArrayList<>();
        if (2 * s % n != 0) {
            System.out.print(-1);
            return;
        }
        if ((2 * s / n - n) % 2 == 0) {
            System.out.print(-1);
            return;
        }
        num = (2 * s / n + 1 - n) / 2;
        for (int i = 0; i < n; i++) {
            list.add(num + i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(' ');
            }
        }
    }
}
