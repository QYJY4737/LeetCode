package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test153 {
    /**
     * 题目0153-机器人活动区域
     * 题目描述
     * 现有一个机器人，可放置于 M×NM \times NM×N 的网格中任意位置，
     * 每个网格包含一个非负整数编号，
     * 当相邻网格的数字编号差值的绝对值小于等于 111 时，
     * 机器人可以在网格间移动
     * 问题： 求机器人可活动的最大范围对应的网格点数目。
     * 说明：
     * <p>
     * 网格左上角坐标为 (0,0)(0,0)(0,0) ,右下角坐标为 (m−1,n−1)(m-1,n-1)(m−1,n−1)
     * 机器人只能在相邻网格间上下左右移动
     * 输入描述
     * 第 111 行输入为 MMM 和 NNN ，MMM 表示网格的行数 NNN 表示网格的列数
     * 之后 MMM 行表示网格数值，每行NNN个数值（数值大小用 kkk 表示），
     * 数值间用单个空格分隔，行首行尾无多余空格
     * MMM、NNN、kkk 均为整数，且 1≤M,N≤1501 \leq M,N \leq 1501≤M,N≤150 ， 0≤k≤500 \leq k \leq 500≤k≤50
     * <p>
     * 输出描述
     * 输出 111 行，包含 111 个数字，表示最大活动区域的网格点数目
     * 行首行尾无多余空格
     * <p>
     * 示例一
     * 输入
     * 4 4
     * 1 2 5 2
     * 2 4 4 5
     * 3 5 7 1
     * 4 6 2 4
     * 输出
     * 6
     * 说明
     * main0153-1.png
     * 图中绿色区域，相邻网格差值绝对值都小于等于 111 ，
     * 且为最大区域，对应网格点数目为 666
     * <p>
     * 示例二
     * 输入
     * 2 3
     * 1 3 5
     * 4 1 3
     * 输出
     * 1
     * 说明
     * main0153-2.png
     * 任意两个相邻网格的差值绝对值都大于 111 ，
     * 机器人不能在网格间移动，只能在单个网格内活动
     * 对应网格点数目为 111
     */

    private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int max = 1;
    private static int k = 1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] matrix = new int[m][n];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }
            solution(m, n, matrix);
            System.out.print(max);
        }
    }

    private static void solution(int m, int n, int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                boolean[][] visited = new boolean[m][n];
                k = 1;
                find(matrix, visited, x, y);
                max = Math.max(k, max);
            }
        }
    }


    public static void find(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int[] d : dic) {
            int newX = x + d[0], newY = y + d[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                if (!visited[newX][newY] && Math.abs(matrix[x][y] - matrix[newX][newY]) <= 1) {
                    k++;
                    find(matrix, visited, newX, newY);
                }
            }
        }
    }
}
