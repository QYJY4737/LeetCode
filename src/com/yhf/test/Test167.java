package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test167 {
    /**
     * 题目0167-开心消消乐
     * 题目描述
     * 给定一个 NNN 行 MMM 列的二维矩阵，矩阵中每个位置的数字取值为 000 或 111，矩阵示例如：
     * <p>
     * 1 1 0 0
     * 0 0 0 1
     * 0 0 1 1
     * 1 1 1 1
     * 现需要将矩阵中所有的 111 进行反转为 000，规则如下：
     * <p>
     * 当点击一个 111 时，该 111 被反转为 000，同时相邻的上、下、左、右，以及左上、左下、右上、右下8个方向的 111 （如果存在111）均会自动反转为 000；
     * 进一步地，一个位置上的 111 被反转为 000 时，与其相邻的8个方向的 111 （如果存在111）均会自动反转为 000；
     * 按照上述规则示例中的矩阵只最少需要点击2次后，所有均值 000 。请问，给定一个矩阵，最少需要点击几次后，所有数字均为0？
     * 输入描述
     * 第一行输入两个整数，分别表示矩阵的行数 NNN 和列数 MMM，取值范围均为 [1,100][1,100][1,100]
     * 接下来 NNN 行表示矩阵的初始值，每行均为 MMM 个数，取值范围 [0,1][0,1][0,1]
     * <p>
     * 输出描述
     * 输出一个整数，表示最少需要点击的次数
     * <p>
     * 示例一
     * 输入
     * 3 3
     * 1 0 1
     * 0 1 0
     * 1 0 1
     * 输出
     * 1
     * 说明
     * 上述样例中，四个角上的 111 均在中间的 111 的相邻8个方向上，因此只需要点击一次即可。
     * <p>
     * 示例二
     * 输入
     * 4 4
     * 1 1 0 0
     * 0 0 0 1
     * 0 0 1 1
     * 1 1 1 1
     * 输出
     * 2
     * 说明
     * 在上述 4×44 \times 44×4 的矩阵中，只需要点击2次，即可将所有的 111 进行消除。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }
            solution(n, m, matrix);
        }
    }

    //  8个方向
    private static final int[][] directions = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {1, 0},
            {-1, 1}, {0, 1}, {1, 1}
    };

    private static void solution(int n, int m, int[][] matrix) {
        int times = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int cur = matrix[x][y];
                if (cur == 1) {
                    times++;
                    LinkedList<int[]> changed = new LinkedList<>();
                    changed.add(new int[]{x, y});
                    change(n, m, matrix, changed);
                }
            }
        }
        System.out.println(times);
    }

    private static void change(int n, int m, int[][] matrix, LinkedList<int[]> changed) {

        if (changed.isEmpty()) {
            return;
        }

        int[] ints = changed.removeFirst();
        for (int[] d : directions) {
            int newX = ints[0] + d[0];
            int newY = ints[1] + d[1];
            if (newX >= 0 && newX < n &&
                    newY >= 0 && newY < m &&
                    matrix[newX][newY] == 1) {
                matrix[newX][newY] = 0;
                changed.add(new int[]{newX, newY});
            }
        }
        change(n, m, matrix, changed);
    }
}
