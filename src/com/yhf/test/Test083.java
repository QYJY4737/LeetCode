package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test083 {
    /**
     * 题目0083-和最大子矩阵
     * 题目描述
     * 给定一个二维整数矩阵
     * 要在这个矩阵中 选出一个子矩阵
     * 使得这个子矩阵内所有的数字和尽量大
     * 我们把这个子矩阵成为“和最大子矩阵”
     * 子矩阵的选取原则，是原矩阵中一段相互连续的矩形区域
     * <p>
     * 输入描述
     * 输入的第一行包含两个整数N,M
     * (1 <= N,M <= 10)
     * 表示一个N行M列的矩阵
     * 下面有N行 每行有M个整数
     * 同一行中每两个数字之间有一个空格
     * 最后一个数字后面没有空格
     * 所有的数字得在-1000 ~ 1000之间
     * <p>
     * 输出描述
     * 输出一行,一个数字
     * 表示选出的“和最大子矩阵”内所有数字的和
     * <p>
     * 示例一
     * 输入
     * 3 4
     * -3 5 -1 5
     * 2 4 -2 4
     * -1 3 -1 3
     * 输出
     * 20
     * 说明
     * 一个3*4的矩阵中
     * 后面3列的和为20,和最大
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] nums = scanner.nextLine().split(" ");
                for (int j = 0; j < nums.length; j++) {
                    matrix[i][j] = Integer.parseInt(nums[j]);
                }
            }
            int res = solution(M, N, matrix);
            System.out.println(res);
        }
    }

    private static int solution(int n, int m, int[][] matrix) {
        int sum = 0;
        int[] b = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++)
                b[k] = 0;
            for (int j = i; j < m; j++) {//枚举初始行i,结束行j
                for (int k = 0; k < n; k++) {
                    b[k] += matrix[j][k];//b[k]为纵向列之和
                }
                max = maxSum(n, b);
                if (max > sum) {
                    sum = max;
                }
            }
        }
        return sum;
    }

    private static int maxSum(int n, int[] a) {
        int sum1 = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (b > 0) {
                b += a[i];
            } else {
                b = a[i];
            }
            if (b > sum1) {
                sum1 = b;
            }
        }
        return sum1;
    }
}
