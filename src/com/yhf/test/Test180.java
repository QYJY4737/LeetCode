package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test180 {
    /**
     * 题目0180-查找单入口空闲区域
     * 题目描述
     * 给定一个 m×nm \times nm×n 的矩阵，由若干字符 X 和 O构成，
     * X表示该处已被占据，O表示该处空闲，请找到最大的单入口空闲区域。
     * <p>
     * 空闲区域是由连通的O组成的区域，位于边界的O可以构成入口，
     * 单入口空闲区域即有且只有一个位于边界的O作为入口的由连通的O组成的区域。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“连通”的。
     * <p>
     * 输入描述
     * 第一行输入为两个数字，
     * 1. 第一个数字为行数 mmm，
     * 2. 第二个数字列数 nnn，两个数字以空格分隔，
     * 1≤m,n≤2001 \leq m, n \leq 2001≤m,n≤200
     * <p>
     * 剩余各行为矩阵各行元素，元素为X 或 O，各元素间以空格分隔。
     * <p>
     * 输出描述
     * 若有唯一符合要求的最大单入口空闲区域，输出三个数字，
     * <p>
     * 第一个数字为入口行坐标（范围为0~行数-1），
     * 第二个数字为入口列坐标（范围为0~列数-1），
     * 第三个数字为区域大小，三个数字以空格分隔；
     * 若有多个符合要求的最大单入口空闲区域，输出一个数字，代表区域的大小；
     * 若没有，输出NULL。
     * <p>
     * 示例一
     * 输入
     * 4 4
     * X X X X
     * X O O X
     * X O O X
     * X O X X
     * 输出
     * 3 1 5
     * 说明
     * 存在最大单入口区域，入口行坐标3，列坐标1，区域大小5
     * <p>
     * 示例二
     * 输入
     * 4 5
     * X X X X X
     * O O O O X
     * X O O O X
     * X O X X O
     * 输出
     * 3 4 1
     * 说明
     * 存在最大单入口区域，入口行坐标3，列坐标4，区域大小1
     * <p>
     * 示例三
     * 输入
     * 5 4
     * X X X X
     * X O O O
     * X O O O
     * X O O X
     * X X X X
     * 输出
     * NULL
     * 说明
     * 示例四
     * 输入
     * 5 4
     * X X X X
     * X O O O
     * X X X X
     * X O O O
     * X X X X
     * 输出
     * 3
     * 说明
     * 存在两个大小为3的最大单入口区域，两个入口横纵坐标分别为1,3和3,3
     */

    private static int[] enter = new int[2];
    private static int count = 0;


    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            char[][] matrix = new char[m][n];
            scanner.nextLine();

            for (int i = 0; i < m; i++) {
                matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
            }

            solution(m, n, matrix);
        }
    }

    private static void solution(int m, int n, char[][] matrix) {
        int max = 0;
        List<int[]> sqrt = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                    List<int[]> poss = new ArrayList<>();
                    poss.add(new int[]{i, j});
                    getSqrt(m, n, matrix, i, j, poss);
                    if (count == 1) {
                        if (max == poss.size()) {
                            sqrt.clear();
                        } else if (max < poss.size()) {
                            sqrt.clear();
                            sqrt.add(new int[]{enter[0], enter[1], poss.size()});
                            max = poss.size();
                        }
                    }
                    count = 0;
                    enter = new int[2];
                }
            }
        }

        if (sqrt.size() == 1) {
            int[] res = sqrt.get(0);
            System.out.printf("%d %d %d", res[0], res[1], res[2]);
        } else if (max != 0) {
            System.out.println(max);
        } else {
            System.out.println("NULL");
        }
    }

    public static void getSqrt(int m, int n, char[][] matrix, int x, int y, List<int[]> list) {

        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
            count++;
            enter[0] = x;
            enter[1] = y;
        }

        if (x < m - 1) {
            if (matrix[x + 1][y] == 'O') {
                matrix[x + 1][y] = 'X';
                list.add(new int[]{x + 1, y});
                getSqrt(m, n, matrix, x + 1, y, list);
            }
        }
        if (y < n - 1) {
            if (matrix[x][y + 1] == 'O') {
                matrix[x][y + 1] = 'X';
                list.add(new int[]{x, y + 1});
                getSqrt(m, n, matrix, x, y + 1, list);
            }
        }
    }
}
