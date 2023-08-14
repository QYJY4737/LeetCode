package com.yhf.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test159 {
    /**
     * 题目0159-对称字符串
     * 题目描述
     * 对称就是最大的美学，现有一道关于对称字符串的美学。
     * 已知：
     * 第 1 个字符串：R
     * 第 2 个字符串：BR
     * 第 3 个字符串：RBBR
     * 第 4 个字符串：BRRBRBBR
     * 第 5 个字符串：RBBRBRRBBRRBRBBR
     * 相信你已经发现规律了，没错！
     * 就是第i个字符串 = 第i-1号字符串的取反 + 第i-1号字符串。
     * 取反即(R->B, B->R);
     * 现在告诉你 n 和 k ，让你求得第n个字符串的第k个字符是多少。
     * (k的编号从0开始)
     * <p>
     * 输入描述
     * 第一行输入一个 TTT ，表示有 TTT 组用例：
     * 接下来输入 TTT 行，每行输入两个数字， 表示 nnn ，kkk
     * 1 <= T <= 100;
     * 1 <= n <= 64;
     * 0 <= k < 2^(n-1);
     * <p>
     * 输出描述
     * 输出 TTT 行表示答案：
     * 输出 blue 表示字符是B；
     * 输出 red 表示字符是R；
     * <p>
     * 示例一
     * 输入
     * 5
     * 1 0
     * 2 1
     * 3 2
     * 4 6
     * 5 8
     * 输出
     * red
     * red
     * blue
     * blue
     * blue
     * 说明
     * 第 1 个字符串：R -> 第 0 个字符为R
     * 第 2 个字符串：BR -> 第 1 个字符为R
     * 第 3 个字符串：RBBR -> 第 2 个字符为B
     * 第 4 个字符串：BRRBRBBR -> 第 6 个字符为B
     * 第 5 个字符串：RBBRBRRBBRRBRBBR -> 第 8 个字符为B
     * <p>
     * 示例二
     * 输入
     * 1
     * 64 73709551616
     * 输出
     * red
     * 说明
     * 备注
     * 输出字符串区分大小写，请注意输出小写字符串，不带双引号
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            long[][] cases = new long[t][2];
            for (int i = 0; i < t; i++) {
                cases[i][0] = scanner.nextLong();
                cases[i][1] = scanner.nextLong();
            }
            solution(t, cases);
        }
    }

    private static void solution(int t, long[][] cases) {

        for (int i = 0; i < t; i++) {
            long n = cases[i][0];
            long k = cases[i][1];
            String res = find(n - 1, k) == 'R' ? "red" : "blue";
            System.out.println(res);
        }
    }

    private static char find(long n, long k) {
        if (n == 0) {
            return 'R';
        }
        // 第n行的长度
        long len = BigInteger.valueOf(2).pow((int) n).longValue();
        // 如果 k 在后半段，则与前一个字符串相同
        if (k >= len / 2) {
            long pos = k - len / 2;
            return find(n - 1, pos);
        } else {
            // 如果 k 在前半段，则与前一个字符串相反
            return find(n - 1, k) == 'R' ? 'B' : 'R';
        }

    }
}
