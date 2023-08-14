package com.yhf.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test189 {
    /**
     * 题目0189-最多等和不相交连续子序列
     * 题目描述
     * 给定一个数组，我们称其中连续的元素为连续子序列，称这些元素的和为连续子序列的和。
     * 数组中可能存在几组连续子序列，组内的连续子序列互不相交且有相同的和。
     * 求一组连续子序列，组内子序列的数目最多。输出这个数目。
     * <p>
     * 输入描述
     * 第一行输入为数组长度 N，1≤N≤103N，1 \leq N \leq 10^3N，1≤N≤10
     * 3
     * 。
     * 第二行为 NNN 个用空格分开的整数 Ci，−105≤Ci≤105C_i，-10^5 \leq C_i \leq 10^5C
     * i
     * ​
     * ，−10
     * 5
     * ≤C
     * i
     * ​
     * ≤10
     * 5
     * 。
     * <p>
     * 输出描述
     * 第一行是一个整数 MMM，表示满足要求的最多的组内子序列的数目。
     * <p>
     * 示例一
     * 输入
     * 10
     * 8 8 9 1 9 6 3 9 1 0
     * 输出
     * 4
     * 说明
     * 四个子序列第一个元素和最后一个元素下标分别为
     * 2 2
     * 4 4
     * 5 6
     * 7 7
     * <p>
     * 示例一
     * 输入
     * 10
     * -1 0 4 -3 6 5 -6 5 -7 -3
     * 输出
     * 3
     * 说明
     * 三个子序列第一个元素和最后一个元素下标分别为
     * 3 3
     * 5 8
     * 9 9
     * <p>
     * 思路
     * 这个题技巧性比较强，很容易进入误区写出复杂度很高的程序
     * 以下解时间复杂度为 O(n2)O(n^2)O(n
     * 2
     * )，空间复杂度为 O(n)O(n)O(n)
     * <p>
     * 使用DP表避免重复计算，找到所有连续子序列，并求和
     * 在所有和中，记录每个和出现的次数以及已经使用过的元素索引
     * 每次如果对合法的和进行累加计数，则判断是否为出现最多的次数
     * 详细见代码实现。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = scanner.nextInt();
            }
            int res = solution(seq, n);
            System.out.println(res);
        }
    }

    private static int solution(int[] seq, int n) {
        int max = 0;
        int[] dp = new int[n];
        System.arraycopy(seq, 0, dp, 0, n);
        Map<Integer, Integer> sumCount = new HashMap<>();
        Map<Integer, HashSet<Integer>> sumPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (i > 0) {
                    dp[j] = dp[j] + seq[j + i];
                }
                int sum = dp[j];
                if (!sumCount.containsKey(sum)) {
                    sumCount.put(sum, 0);
                    sumPos.put(sum, new HashSet<>());
                }

                boolean exists = false;
                HashSet<Integer> poss = sumPos.get(sum);
                for (int k = j; k <= j + i; k++) {
                    if (exists = poss.contains(k)) {
                        break;
                    }
                }
                if (!exists) {
                    int newSum = sumCount.get(sum) + 1;
                    sumCount.put(sum, newSum);
                    max = Math.max(max, newSum);
                    for (int k = j; k <= j + i; k++) {
                        poss.add(k);
                    }
                    sumPos.put(sum, poss);
                }
            }
        }

        return max;
    }
}
