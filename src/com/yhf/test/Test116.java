package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test116 {
    /**
     * 题目0116-聚餐地点
     * 题目描述
     * 小华和小为是很好的朋友，他们约定周末一起吃饭，
     * 通过手机交流，他们在地图上选择了很多聚餐地点
     * （由于自然地形等原因，部分聚餐地点不可达），
     * 求小华和小为能能达到的聚餐地点有多少个。
     *
     * 输入描述
     * 第一行输入m和n，m表示地图长度，n表示地图宽度
     * 第二行开始具体输入地图信息，地图信息包括
     * 0为通畅的道路
     * 1为障碍物（且仅1为障碍物）
     * 2为小华或小为，地图中必定有且仅有两个（非障碍物）
     * 3为被选中的聚餐地点（非障碍物）
     *
     * 输出描述
     * 可以两方都到达的聚餐地点的数量，行末无空格
     *
     * 示例一
     * 输入
     * 4 4
     * 2 1 0 3
     * 0 1 2 1
     * 0 3 0 0
     * 0 0 0 0
     * 输出
     * 2
     * 说明
     * 第一行输入地图的长宽为三和四
     * 第二行开始为具体的地图，其中：
     * 3代表小华和小明的聚餐地点；
     * 2：代表小华或小明（确保有两个）；
     * 0代表可以通行的位置；
     * 1代表不可以出行的位置。
     * 此时两者都能达到的聚餐位置有两处
     *
     * 备注：
     * 地图长宽为m和n,4 <= m <= 100 ，4 <= n <= 100
     * 聚餐的地点数量为k，则1 < k <= 100
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] ints = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ints[i][j] = scanner.nextInt();
                }
            }
            solution(m,n,ints);
        }
    }

    private static void solution(int m, int n, int[][] ints) {
        // 遍历 矩阵

        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 是2 则开始寻找路径
                if (ints[i][j] == 2) {
                    boolean[][] visited = new boolean[m][n];

                    if (n1 == 0) {
                        n1 = find(ints, visited, i, j, n1);
                    } else {
                        n2 = find(ints, visited, i, j, n2);
                    }
                }
            }
        }

        System.out.println(Math.min(n1, n2));
    }

    private static int find(int[][] ints, boolean[][] visited, int x, int y, int n) {
        if (ints[x][y] == 1) {
            return n;
        }
        if (ints[x][y] == 3) {
            if (!visited[x][y]) {
                visited[x][y] = true;
                n += 1;
            }
            return n;
        }
        visited[x][y] = true;

        int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dic) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX >= 0 && newX < ints.length &&
                    newY >= 0 && newY < ints[0].length) {
                if (!visited[newX][newY]) {
                    n = find(ints, visited, newX, newY, n);
                }
            }
        }
        return n;
    }
}
