package com.yhf.test1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test217 {
    /**
     * 题目0217-上班之路
     * 题目描述
     * Jungle生活在美丽的蓝鲸城，大马路都是方方正正，但是每天马路的封闭情况都不一样。
     * 地图由以下元素组成：
     * <p>
     * . — 空地，可以达到;
     * * — 路障，不可达到;
     * S — Jungle的家;
     * T — 公司.
     * 其中我们会限制Jungle拐弯的次数，同时Jungle可以清除给定个数的路障，现在你的任务是计算Jungle是否可以从家里出发到达公司。
     * 输入描述
     * 输入的第一行为两个整数 t,c（0≤t,c≤100）t, c（0 \leq t,c \leq 100）t,c（0≤t,c≤100）, ttt代表可以拐弯的次数，ccc代表可以清除的路障个数。
     * 输入的第二行为两个整数 n,m（1≤n,m≤100）n, m（1 \leq n,m \leq 100）n,m（1≤n,m≤100）,代表地图的大小。
     * 接下来是 nnn 行包含 mmm 个字符的地图。nnn 和 mmm 可能不一样大。
     * 我们保证地图里有 SSS 和 TTT。
     * <p>
     * 输出描述
     * 输出是否可以从家里出发到达公司，是则输出YES，不能则输出NO。
     * <p>
     * 示例一
     * 输入
     * 2 0
     * 5 5
     * ..S..
     * ****.
     * T....
     * ****.
     * .....
     * 输出
     * YES
     * 示例二
     * 输入
     * 1 2
     * 5 5
     * .*S*.
     * *****
     * ..*..
     * *****
     * T....
     * 输出
     * NO
     * 说明
     * 该用例中，至少需要拐弯1次，清除3个路障，所以无法到达
     */

    static int t, c, n, m;
    static String[][] matrix;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            t = scanner.nextInt();
            c = scanner.nextInt();

            n = scanner.nextInt();
            m = scanner.nextInt();

            matrix = new String[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.next().split("");
            }

            System.out.println(solution());
        }
    }

    public static String solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("S".equals(matrix[i][j])) {
                    HashSet<Integer> path = new HashSet<>();
                    path.add(i * m + j);
                    return dfs(i, j, 0, 0, 0, path) ? "YES" : "NO";
                }
            }
        }
        return "NO";
    }

    static int[][] offsets = {{-1, 0, 1}, {1, 0, 2}, {0, -1, 3}, {0, 1, 4}};

    public static boolean dfs(int si, int sj, int ut, int uc, int lastDirect, HashSet<Integer> path) {
        if ("T".equals(matrix[si][sj])) {
            return true;
        }

        for (int[] offset : offsets) {
            int direct = offset[2];
            int newI = si + offset[0];
            int newJ = sj + offset[1];

            boolean flag1 = false;
            boolean flag2 = false;

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                int pos = newI * m + newJ;
                if (path.contains(pos)) continue;

                if (lastDirect != 0 && lastDirect != direct) {
                    if (ut + 1 > t) continue;
                    flag1 = true;
                }

                if ("*".equals(matrix[newI][newJ])) {
                    if (uc + 1 > c) continue;
                    flag2 = true;
                }

                path.add(pos);

                boolean res = dfs(newI, newJ, ut + (flag1 ? 1 : 0), uc + (flag2 ? 1 : 0), direct, path);

                if (res) return true;

                path.remove(pos);
            }
        }
        return false;
    }
}
