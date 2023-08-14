package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test156 {
    /**
     * 题目0156-计算网络信号
     * 题目描述
     * 网络信号经过传递会逐层衰减，且遇到阻隔物无法直接穿透，在此情况下需要计算某个位置的网络信号值。
     * 注意:网络信号可以绕过阻隔物
     *
     * array[m][n] 的二维数组代表网格地图，
     * array[i][j] = 0代表i行j列是空旷位置;
     * array[i][j] = x(x为正整数)代表i行j列是信号源，信号强度是x;
     * array[i][j] = -1代表i行j列是阻隔物.
     * 信号源只有1个，阻隔物可能有0个或多个
     * 网络信号衰减是上下左右相邻的网格衰减1
     * 现要求输出对应位置的网络信号值。
     * 输入描述
     * 输入为三行，第一行为 mmm、nnn，代表输入是一个 m×nm \times nm×n 的数组。
     * 第二行是一串 m×nm \times nm×n 如个用空格分隔的整数.
     * 每连续 nnn 个数代表一行，再往后 nnn 个代表下一行，以此类推。
     * 对应的值代表对应的网格是空矿位置，还是信号源，还是阻隔物。
     * 第三行是 iii 、jjj，代表需要计算array[i][j]的网络信号值。
     * 注意:此处 iii 和 jjj均从 0 开始，即第一行 iii 为 0
     *
     * 例如
     *
     * 6 5
     * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
     * 1 4
     * 代表如下地图
     * 4
     *
     * 需要输出第1行第4列的网络信号值，如下图，值为2
     *
     * 1
     * 1
     * 1
     * 2
     * 3
     * 2
     * 0
     * 4
     * 3
     * 1
     * 2
     * 3
     * 2
     * 1
     * 2
     * 1
     *
     * 输出描述
     * 输出对应位置的网络信号值，如果网络信号未覆盖到，也输出0。
     * 一个网格如果可以途径不同的传播衰减路径传达，取较大的值作为其信号值。
     *
     * 示例一
     * 输入
     * 6 5
     * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
     * 1 4
     * 输出
     * 2
     * 说明
     * 示例二
     * 输入
     * 6 5
     * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
     * 2 1
     * 输出
     * 0
     * 说明
     * 备注
     * mmm 不一定等于 nnn ，m<100,n<100m < 100,n < 100m<100,n<100 ,网络信号之小于 100010001000 。
     * 信号源只有1个，阻隔物可能有0个或多个。
     * 输入的 mmm ，nnn 与第二行的数组是合法的，无需处理数量对不上的异常情况。
     * 要求输出信号值的位置，不会是阻隔物。
     */

    private static class Block {
        int x;
        int y;
        int d;

        public Block(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] matrix = new int[m][n];
            int[] src = new int[2];
            int[] dst = new int[2];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = scanner.nextInt();
                    if (matrix[x][y] > 0) {
                        src[0] = x;
                        src[1] = y;
                    }
                }
            }
            dst[0] = scanner.nextInt();
            dst[1] = scanner.nextInt();
            int res = solution(matrix, src, dst);
            System.out.print(res);
        }
    }

    private static final LinkedList<Block> blocks = new LinkedList<>();

    private static int solution(int[][] matrix, int[] src, int[] dst) {

        int x = src[0];
        int y = src[1];


        blocks.add(new Block(x, y, matrix[x][y]));
        while (blocks.size() > 0) {
            Block block = blocks.removeFirst();
            diffuse(matrix, block.x, block.y, block.d);
        }


        return matrix[dst[0]][dst[1]];
    }

    private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void diffuse(int[][] matrix, int x, int y, int d) {
        for (int[] di : dic) {
            int newX = x + di[0], newY = y + di[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                int next = matrix[newX][newY];

                if (next == 0) {
                    matrix[newX][newY] = d - 1;
                }

                if (d > 2 && next != -1) {
                    blocks.add(new Block(newX, newY, d - 1));
                }
            }
        }
    }
}
