package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test168 {
    /**
     * 题目0168-统计匹配的二元组个数
     * 题目描述
     * 给定两个数组 AAA 和 BBB，若数组 AAA 的某个元素 A[i]A[i]A[i] 与数组 BBB 中的某个元素 B[j]B[j]B[j] 满足 A[i]==B[j]A[i]==B[j]A[i]==B[j]，则寻找到一个匹配的二元组 (i,j)(i,j)(i,j) ，请统计再这两个数组 AAA 和 BBB 中，一共存在多少个这样的二元组。
     * <p>
     * 输入描述
     * 第一行输入数组 AAA 的长度 MMM ；
     * 第一行输入数组 BBB 的长度 NNN ；
     * 第三行输入数组 AAA 的值；
     * 第四行输入数组 BBB 的值。
     * 1≤M,N≤1000001 \leq M,N \leq 1000001≤M,N≤100000
     * A,BA,BA,B 数组中数值的取值均小于 100000100000100000
     * <p>
     * 输出描述
     * 输出匹配的二元组个数
     * <p>
     * 示例一
     * 输入
     * 5
     * 4
     * 1 2 3 4 5
     * 4 3 2 1
     * 输出
     * 4
     * 说明
     * 若下标从 000 开始，则匹配的二元组分别为(0,3), (1,2), (2,1), (3,0)，共计 444 个
     * <p>
     * 示例二
     * 输入
     * 6
     * 3
     * 1 2 4 4 2 1
     * 1 2 3
     * 输出
     * 4
     * 说明
     * 若下标从 000 开始，则匹配的二元组分别为(0,0), (1,1), (4,1), (5,0)，共计 444 个
     * <p>
     * 备注
     * 若不存在相等的值，则输出 000 ，所采用的算法复杂度需小于 O(N2)O(N^2)O(N
     * 2
     * )，否则会超时。输入数组中允许出现重复数字，一个数字可以匹配多次。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] arrayA = new int[m];
            int[] arrayB = new int[n];
            for (int i = 0; i < m; i++) {
                arrayA[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrayB[i] = scanner.nextInt();
            }
            int count = solution(arrayA, arrayB);
            System.out.println(count);
        }
    }

    private static int solution(int[] arrayA, int[] arrayB) {
        int count = 0;

        Arrays.sort(arrayB);

        for (int i : arrayA) {
            int res = Arrays.binarySearch(arrayB, i);
            if (res >= 0) {
                count++;
            }
        }
        return count;
    }
}
