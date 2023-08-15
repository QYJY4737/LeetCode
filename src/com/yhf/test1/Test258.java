package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test258 {
    /**
     * 题目0258-数组连续和
     * 题目描述
     * 给定一个含有 NNN 个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于 xxx 。
     * <p>
     * 输入描述
     * 第一行两个整数 NNN xxx (0<N≤100000,0≤x≤10000000)(0 < N \leq 100000, 0 \leq x \leq 10000000)(0<N≤100000,0≤x≤10000000)
     * 第二行有 NNN 个正整数(每个正整数小于等于 100100100 )。
     * <p>
     * 输出描述
     * 输出一个整数，表示所求的个数。
     * 注意：此题对效率有要求，暴力解法通过率不高，请考虑高效的实现方式。
     * <p>
     * 示例一
     * 输入
     * 3 7
     * 3 4 7
     * 输出
     * 4
     * 说明
     * 第一行的3表示第二行数组输入3个数，第一行的7是比较数，用于判断连续数组是否大于该数；组合为 3 + 4; 3 + 4 + 7; 4 + 7; 7; 都大于等于指定的7；所以共四组。
     * <p>
     * 示例二
     * 输入
     * 10 10000
     * 1 2 3 4 5 6 7 8 9 10
     * 输出
     * 0
     * 说明
     * 所有元素的和小于10000，所以返回0。
     * <p>
     * ¶思路解析和复杂度分析
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(solution(n, x, arr));
        }

    }

    public static long solution(int n, int x, int[] arr) {
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        int l = 0;
        int r = 1;
        long ans = 0;

        while (r <= n) {
            if (preSum[r] - preSum[l] >= x) {
                ans += n - r + 1;
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }

        return ans;
    }
}
