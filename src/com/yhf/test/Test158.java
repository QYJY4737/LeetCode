package com.yhf.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test158 {
    /**
     * 题目0158-快递业务站
     * 题目描述
     * 快递业务范围有 N 个站点，A 站点与 B 站点可以中转快递，则认为 A-B 站可达，
     * 如果 A-B 可达，B-C 可达，则 A-C 可达。
     * 现在给 N 个站点编号 0、1、...n-1，用 s[i][j]表示 i-j 是否可达，
     * s[i][j] = 1表示 i-j可达，s[i][j] = 0表示 i-j 不可达。
     * 现用二维数组给定N个站点的可达关系，请计算至少选择从几个主站点出发，才能可达所有站点（覆盖所有站点业务）。
     * 说明：s[i][j]与s[j][i]取值相同。
     *
     * 输入描述
     * 第一行输入为 N，N表示站点个数。 1 < N < 10000
     * 之后 N 行表示站点之间的可达关系，第i行第j个数值表示编号为i和j之间是否可达。
     *
     * 输出描述
     * 输出站点个数，表示至少需要多少个主站点。
     *
     * 示例一
     * 输入
     * 4
     * 1 1 1 1
     * 1 1 1 0
     * 1 1 1 0
     * 1 0 0 1
     * 输出
     * 1
     * 说明
     * 选择 0 号站点作为主站点， 0 站点可达其他所有站点，
     * 所以至少选择 1 个站点作为主站才能覆盖所有站点业务
     *
     * 示例二
     * 输入
     * 4
     * 1 1 0 0
     * 1 1 0 0
     * 0 0 1 0
     * 0 0 0 1
     * 输出
     * 3
     * 说明
     * 选择 0 号站点可以覆盖 0、1 站点，
     * 选择 2 号站点可以覆盖 2 号站点，
     * 选择 3 号站点可以覆盖 3 号站点，
     * 所以至少选择 3 个站点作为主站才能覆盖所有站点业务
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int res = solution(n, matrix);
            System.out.println(res);

        }
    }

    private static int solution(int n, int[][] matrix) {
        int count = 0;
        Set<Integer> cover = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!cover.contains(i)) {
                count++;
            }
            int[] site = matrix[i];
            for (int j = 0; j < site.length; j++) {
                if (site[j] == 1) {
                    cover.add(j);
                }
            }
        }
        return count;
    }
}
