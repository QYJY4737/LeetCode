package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test100 {
    /**
     * 题目0100-找单词
     * 题目描述
     * 给一个字符串和一个二维字符数组，如果该字符串存在于该数组中，则按字符串的字符顺序输出字符串每个字符所在单元格的位置下标字符串，如果找不到返回字符串N。
     *
     * 需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是指那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 假定在数组中最多只存在一个可能的匹配。
     * 输入描述
     * 第1行为一个数字N指示二维数组在后续输入所占的行数。
     * 第2行到第N+1行输入为一个二维大写字符数组，每行字符用半角,分割。
     * 第N+2行为待查找的字符串，由大写字符组成。
     * 二维数组的大小为N*N，0 < N <= 100。
     * 单词长度K，0 < K < 1000。
     * 输出描述
     * 输出一个位置下标字符串，拼接格式为：第1个字符行下标+","+第1个字符列下标+","+第2个字符行下标+","+第2个字符列下标...+","+第N个字符行下标+","+第N个字符列下标示例1
     *
     * 示例一
     * 输入
     * 4
     * A,C,C,F
     * C,D,E,D
     * B,E,S,S
     * F,E,C,A
     * ACCESS
     * 输出
     * 0,0,0,1,0,2,1,2,2,2,2,3
     * 说明
     * ACCESS分别对应二维数组的[0,0] [0,1] [0,2] [1,2] [2,2] [2,3]下标位置
     */

    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll(",", "")
                    .toCharArray();
        }
        String word = scanner.nextLine();
        scanner.close();

        if (exist(matrix, word)) {
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i));
                if (i != 0) {
                    System.out.print(",");
                }
            }
        } else {
            System.out.println("N");
        }

    }

    public static boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    res.add(i + "," + j);
                    return flag;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board,
                                boolean[][] visited,
                                int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length &&
                    newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        res.add(newi + "," + newj);
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
