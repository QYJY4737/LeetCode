package com.yhf.test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test215 {
    /**
     * 题目0215-优雅数组
     * 题目描述
     * 如果一个数组中出现次数最多的元素出现大于等于 kkk 次，被称为k-优雅数组，kkk 也可以被称为优雅阈值。
     * 例如，数组[1, 2, 3, 1, 2, 3, 1]，它是一个3-优雅数组，因为元素1出现次数大于等于3次，
     * 数组[1, 2, 3, 1, 2]就不是一个3-优雅数组，因为其中出现次数最多的元素时1和2，只出现了2次。
     *
     * 给定一个数组 AAA 和 kkk，请求出 AAA 有多少子数组是k-优雅子数组。
     * 子数组是数组中一个或多个连续元素组成的数组。
     * 例如，数组[1, 2, 3, 4]包含10个子数组，分别是：
     * [1]，
     * [1, 2]，
     * [1, 2, 3]，
     * [1, 2, 3, 4]，
     * [2]，
     * [2, 3]，
     * [2, 3, 4]，
     * [3]，
     * [3, 4]，
     * [4]。
     *
     * 输入描述
     * 第一行输入两个整数 nnn 和 kkk，nnn 是数组 AAA 的长度，kkk 是优雅阈值。
     * 第二行输入 nnn 个整数，表示给定的数组 AAA。
     * 1≤n≤10000,1≤k≤n1 \leq n \leq 10000, 1 \leq k \leq n1≤n≤10000,1≤k≤n
     * 数组 AAA 中的元素 A[i]A[i]A[i] 满足：1≤A[i]≤n1 \leq A[i] \leq n1≤A[i]≤n
     *
     * 输出描述
     * 数据一个整数，表示数组 AAA 中k-优雅子数组的数量
     * 行尾不要有多余空格
     *
     * 示例一
     * 输入
     * 7 3
     * 1 2 3 1 2 3 1
     * 输出
     * 1
     * 说明
     * 只有子数组[1, 2, 3, 1, 2, 3, 1]是3-优雅数组
     *
     * 示例二
     * 输入
     * 7 2
     * 1 2 3 1 2 3 1
     * 输出
     * 10
     * 说明
     * 10个优雅子数组分别是（下标从0计数）：
     *
     * 长度为4：[1, 2, 3, 1](下标0~3), [2, 3, 1, 2](下标1~4), [3, 1, 2, 3](下标2~5), [1, 2, 3, 1](下标3~6)
     * 长度为5：[1, 2, 3, 1, 2](下标0~4), [2, 3, 1, 2, 3](下标1~5), [3, 1, 2, 3, 1](下标2~6)
     * 长度为6：[1, 2, 3, 1, 2, 3](下标0~5), [2, 3, 1, 2, 3, 1](下标1~6)
     * 长度为7：[1, 2, 3, 1, 2, 3, 1](下标0~6)
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(solution(arr, n, k));
        }
    }

    public static int solution(int[] arr, int n, int k) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> count = new HashMap<>();

            for (int j = i; j < n; j++) {
                Integer key = arr[j];
                count.put(key, count.getOrDefault(key, 0) + 1);
                if (count.get(key) >= k) {
                    res += n - j;
                    break;
                }
            }
        }

        return res;
    }
}
