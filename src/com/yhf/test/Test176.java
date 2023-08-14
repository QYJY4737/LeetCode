package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test176 {
    /**
     * 题目0176-基站维修工程师
     * 题目描述
     * 小王是一名基站维护工程师，负责某区域的基站维护。
     * 某地方有 nnn 个基站（ 1<n<101 < n < 101<n<10 ），已知各基站之间的距离 sss（ 0<s<5000 < s < 5000<s<500 ），
     * 并且基站 xxx 到基站 yyy 的距离，与基站 yyy 到 基站xxx 的距离并不一定会相同。
     * 小王从基站 111 出发，途经每个基站 111 次，然后返回基站 111 ，需要请你为他选择一条距离最短的路。
     *
     * 输入描述
     * 站点数n和各站点之间的距离(均为整数)。
     * 如：
     *
     * 3 {站点数}
     * 0 2 1 {站点1到各站点的路程}
     * 1 0 2 {站点2到各站点的路程}
     * 2 1 0 {站点3到各站点的路程}
     * 输出描述
     * 最短路程的数值
     *
     * 示例一
     * 输入
     * 3
     * 0 2 1
     * 1 0 2
     * 2 1 0
     * 输出
     * 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[][] distances = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = scanner.nextInt();
                }
            }
            int res = solution(n, distances);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[][] distances) {
        int shortestRoute = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == 0) continue;
            int route = distances[0][i] + distances[i][0];
            shortestRoute = Math.min(shortestRoute, route);
        }
        return shortestRoute;
    }
}
