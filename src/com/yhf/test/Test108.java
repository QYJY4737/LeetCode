package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test108 {
    /**
     * 题目0108-找到它
     * 题目描述
     * 找到它是个小游戏，你需要在一个矩阵中找到给定的单词
     * 假设给定单词HELLOWORLD，在矩阵中只要能找HELLOWORLD就算通过
     * 注意区分英文字母大小写，并且你只能上下左右行走 不能走回头路
     *
     * 输入描述
     * 输入第一行包含两个整数M N ( 0 < N , M < 21 )
     * 分别表示N行M列的矩阵
     * 第二行是长度不超过100的单词W
     * 在整个矩阵中给定单词W只会出现一次
     * 从第3行到第N+2是只包含大小写英文字母的长度为M的字符串矩阵
     *
     * 输出描述
     * 如果能在矩阵中连成给定的单词，则输出给定单词首字母在矩阵中的位置
     * 第几行第几列
     * 否则输出NO
     *
     * 示例一
     * 输入
     * 5 5
     * HELLOWORLD
     * CPUCY
     * EKLQH
     * CHELL
     * LROWO
     * DGRBC
     * 输出
     * 3 2
     * 示例二
     * 输入
     * 5 5
     * Helloworld
     * CPUCh
     * wolle
     * orldO
     * EKLQo
     * PGRBC
     * 输出
     * NO
     * 说明
     * 区分大小写
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(" ");
            int M = Integer.parseInt(split[0]);
            int N = Integer.parseInt(split[1]);
            String W = scanner.nextLine();
            char[][] matrix = new char[N][M];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = scanner.nextLine().toCharArray();
            }
            String res = solution(matrix, W);
            System.out.println(res);
        }
    }

    public static boolean find(char[][] board,
                               boolean[][] visited,
                               int x, int y, String s, int k) {
        if (board[x][y] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : dic) {
            int newx = x + dir[0], newy = y + dir[1];
            if (newx >= 0 && newx < board.length &&
                    newy >= 0 && newy < board[0].length) {
                if (!visited[newx][newy]) {
                    boolean flag = find(board, visited, newx, newy, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return result;
    }

    public static String solution(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = find(board, visited, i, j, word, 0);
                if (flag) {
                    return (i + 1) + " " + (j + 1);
                }
            }
        }
        return "NO";
    }
}
