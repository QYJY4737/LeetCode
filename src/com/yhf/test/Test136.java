package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test136 {
    /**
     * 题目0136-病菌感染
     * 题目描述
     * 在一个地图中(地图有N*N个区域组成)
     * 有部分区域被感染病菌
     * 感染区域每天都会把周围上下左右的四个区域感染
     * 请根据给定的地图计算多少天以后全部区域都会被感染
     * 如果初始地图上所有区域都被感染
     * 或者没有被感染区域返回-1
     *
     * 备注
     * 1 <= N < 200
     *
     * 输入描述
     * 一行N*N个数字只包含0 1 ，不会有其他数字
     * 表示一个地图
     * 数字间用,分割
     * 0表示未感染区域
     * 1表示感染区域
     * 每N个数字表示地图中一行
     * 输入数据共表示N行N列的区域地图
     * 例如输入
     * 1,0,1,0,0,0,1,0,1
     * 表示地图
     * 1,0,1
     * 0,0,0
     * 1,0,1
     *
     * 输出描述
     * 一个整数表示经过多少天以后全部区域都会被感染
     *
     * 示例一
     * 输入
     * 1,0,1,0,0,0,1,0,1
     * 输出
     * 2
     * 说明
     * 1天以后地图中仅剩中心点未被感染
     * 2天以后全部被感染
     *
     * 示例二
     * 输入
     * 0,0,0,0
     * 输出
     * -1
     * 说明
     * 无感染区域
     *
     * 示例三
     * 输入
     * 1,1,1,1,1,1,1,1,1
     * 输出
     * -1
     * 说明
     * 全部感染
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String mapString = scanner.nextLine();
            solution(mapString);
        }
    }

    private static void solution(String mapString) {
        String[] split = mapString.split(",");
        int n = (int) Math.sqrt(split.length);

        int[][] ints = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(split[k]);
                k++;
            }
        }

        int day = 0;

        while (check(ints)) {
            // 找到所有感染位点
            LinkedList<int[]> virus = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = ints[i][j];
                    if (x == 1) {
                        int[] pos = {i, j};
                        virus.add(pos);
                    }
                }
            }

            // 感染
            for (int[] pos : virus) {
                infect(ints, pos[0], pos[1]);
            }

            day++;
        }

        day = day == 0 ? -1 : day;
        System.out.println(day);
    }

    static int[][] POS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static void infect(int[][] ints, int x, int y) {
        int n = ints.length;
        for (int[] p : POS) {
            int x1 = x + p[0];
            x1 = Math.min(n - 1, Math.max(x1, 0));
            int y1 = y + p[1];
            y1 = Math.min(n - 1, Math.max(y1, 0));
            ints[x1][y1] = 1;
        }
    }


    private static boolean check(int[][] ints) {
        int sum = 0;
        int n = ints.length;
        for (int[] arr : ints) {
            for (int j = 0; j < n; j++) {
                sum += arr[j];
            }
        }
        return sum != 0 && sum != n * n;
    }
}
