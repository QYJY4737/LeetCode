package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test170 {
    /**
     * 题目0170-工作安排
     * 题目描述
     * 小明每周上班都会拿到自己的工作清单，工作清单内包含 nnn 项工作，每项工作都有对应的耗时时间（单位 hhh ）和报酬,
     * 工作的总报酬为所有已完成工作的报酬之和，那么请你帮小明安排一下工作，保证小明在指定的工作时间内工作收入最大化。
     * <p>
     * 输入描述
     * 输入的第一行为两个正整数 TTT，nnn。
     * TTT 代表工作时长（单位 hhh， 0<T<10000000 < T < 10000000<T<1000000 ），
     * nnn 代表工作数量（ 1<n≤30001 < n \leq 30001<n≤3000 ）。
     * 接下来是 nnn 行，每行包含两个整数 ttt， www。
     * ttt 代表该工作消耗的时长（单位 hhh， t>0t > 0t>0）, www 代表该项工作的报酬。
     * <p>
     * 输出描述
     * 输出小明指定工作时长内工作可获得的最大报酬。
     * <p>
     * 示例一
     * 输入
     * 40 3
     * 20 10
     * 20 20
     * 20 5
     * 输出
     * 30
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = scanner.nextInt();
                jobs[i][1] = scanner.nextInt();
            }
            int res = solution(jobs, T);
            System.out.println(res);
        }
    }

    private static int solution(int[][] jobs, int t) {
        if (t <= 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int[] job : jobs) {
            min = Math.min(min, job[0]);
        }
        int[][] dp = new int[jobs.length + 1][t + 1];
        for (int i = 1; i <= jobs.length; i++) {
            for (int j = min; j <= t; j++) {
                int[] job = jobs[i - 1];
                int v = dp[i - 1][j];
                int newV = job[0] > j ? 0 : job[1] + dp[i - 1][j - job[0]];
                dp[i][j] = Math.max(v, newV);
            }
        }

        return dp[jobs.length][t];
    }
}
