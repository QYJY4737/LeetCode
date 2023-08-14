package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test119 {
    /**
     * 题目0119-最大相连男生数
     * 题目描述
     * 学校组织活动，将学生排成一个矩形方阵。
     * 请在矩形方阵中找到最大的位置相连的男生数量。
     * 这个相连位置在一个直线上，方向可以是水平的、垂直的、成对角线的或者反对角线的。
     * 注：学生个数不会超过10000。
     *
     * 输入描述
     * 输入的第一行为矩阵的行数和列数，接下来的n行为矩阵元素，元素间用,分隔。
     *
     * 输出描述
     * 输出一个整数，表示矩阵中最长的位置相连的男生个数。
     *
     * 示例一
     * 输入
     * 3,4
     * F,M,M,F
     * F,M,M,F
     * F,F,F,M
     * 输出
     * 3
     */

    private static int maxLen = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(",");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] chars = scanner.nextLine().split(",");
                for (int j = 0; j < chars.length; j++) {
                    matrix[i][j] = chars[j].charAt(0);
                }
            }
            solution(n, m, matrix);
        }
    }

    private static void solution(int n, int m, char[][] matrix) {
        int[][] actions = {{0, 1}, {1, 0}, {1, 1}, {-1, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] action : actions) {
                    find(matrix, action, i, j);
                }
            }
        }
        System.out.println(maxLen);
    }


    private static void find(char[][] matrix, int[] action, int r, int c) {
        int count = 0;
        while (r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[0].length) {
//      System.out.printf("[%d,%d]\n", r, c);

            if (matrix[r][c] == 'M') {
                count++;
            } else {
                maxLen = Math.max(count, maxLen);
                count = 0;
            }
            r += action[0];
            c += action[1];
        }

        maxLen = Math.max(count, maxLen);
    }
}
