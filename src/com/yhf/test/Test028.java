package com.yhf.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test028 {
    /**
     * 题目0028-矩阵最值
     * 题目描述
     * 给定一个仅包含0和1的n*n二维矩阵
     * 请计算二维矩阵的最大值
     * 计算规则如下
     * <p>
     * 每行元素按下标顺序组成一个二进制数(下标越大约排在低位)，
     * 二进制数的值就是该行的值，矩阵各行之和为矩阵的值
     * 允许通过向左或向右整体循环移动每个元素来改变元素在行中的位置
     * 比如
     * [1,0,1,1,1]向右整体循环移动两位[1,1,1,0,1]
     * 二进制数为11101值为29
     * [1,0,1,1,1]向左整体循环移动两位[1,1,1,1,0]
     * 二进制数为11110值为30
     * 输入描述
     * 数据的第一行为正整数，记录了N的大小，0 < N <= 20
     * 输入的第2到n+1行为二维矩阵信息，行内元素边角逗号分割
     * 输出描述
     * 矩阵的最大值
     * <p>
     * 示例一
     * 输入
     * 5
     * 1,0,0,0,1
     * 0,0,0,1,1
     * 0,1,0,1,0
     * 1,0,0,1,1
     * 1,0,1,0,1
     * 输出
     * 122
     * 说明
     * 第一行向右整体循环移动一位，得到最大值 11000 24
     * 11000
     * 10100
     * 11100
     * 10110
     * 因此最大122
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = scanner.nextLine();
            }
            solution(n, lines);
        }
    }

    private static void solution(int n, String[] lines) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> ints = new LinkedList<>();
            Arrays.stream(lines[i].split(","))
                    .forEach(x -> ints.add(Integer.parseInt(x)));
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                ints.addLast(ints.remove(0));

                String binInt = ints.toString()
                        .replaceAll("\\W+", "");

                int sum = Integer.parseInt(binInt, 2);
                if (sum > max) max = sum;
            }
            res += max;
        }

        System.out.print(res);
    }
}
