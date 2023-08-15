package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test259 {
    /**
     * 题目0259-字符串划分
     * 题目描述
     * 给定一个小写字母组成的字符串 sss，请找出字符串中两个不同位置的字符作为分割点，使得字符串分成的三个连续子串且子串权重相等，注意子串不包含分割点。
     * 若能找到满足条件的两个分割点，请输出这两个分割点在字符串中的位置下标，若不能找到满足条件的分割点请返回0,0。
     * 子串权重计算方式为:子串所有字符的ASCII码数值之和。
     * <p>
     * 输入描述
     * 输入为一个字符串，字符串由a~z，26个小写字符组成，5≤字符串长度≤2005 \leq 字符串长度 \leq 2005≤字符串长度≤200。
     * <p>
     * 输出描述
     * 输出为两个分割点在字符串中的位置下标，以逗号分隔
     * <p>
     * 示例一
     * 输入
     * acdbbbca
     * 输出
     * 2,5
     * 说明
     * 以位置2和5作为分割点，将字符串分割为ac，bb，ca三个子串，每一个的子串权重都为196，输出为: 2,5
     * <p>
     * 示例二
     * 输入
     * abcabc
     * 输出
     * 0,0
     * 说明
     * 找不到符合条件的分割点，输出为0,0
     * <p>
     * 备注
     * 只考虑唯一解，不存在一个输入多种输出解的情况
     * <p>
     * 思路解析和复杂度分析
     * 思路解析
     * 题目的目标是找到两个分割点，使得这两个分割点将字符串分割成三个连续的子串，且三个子串的权重相等。这里的子串权重是指子串中所有字符的ASCII码值之和。
     * <p>
     * 解题的核心思路是使用前缀和以及双指针移动的策略。
     * <p>
     * 首先，计算字符串中每个位置的前缀和，前缀和数组的第i个元素表示的是字符串中前i个字符的ASCII码值之和。
     * <p>
     * 然后，初始化两个指针，指针i和j，分别指向字符串的第1个和第2个字符。在每次循环中，计算出以i和j为分割点将字符串分割成三个子串的情况下，这三个子串的权重。如果三个子串的权重相等，那么就找到了满足条件的两个分割点，输出这两个分割点的位置并返回。
     * <p>
     * 如果三个子串的权重不等，那么就需要移动指针i和j。由于字符串的长度是固定的，因此如果第一个子串的权重小于第二个子串的权重，那么可以通过移动指针i来增大第一个子串的权重，反之，可以通过移动指针j来减小第二个子串的权重。
     * <p>
     * 如果在指针j移动到字符串末尾的时候，仍然没有找到满足条件的两个分割点，那么就输出0,0。
     * <p>
     * 复杂度分析
     * 时间复杂度：计算前缀和的时间复杂度为 O(n)O(n)O(n)，移动指针的时间复杂度也为 O(n)O(n)O(n)，因此总的时间复杂度为 O(n)O(n)O(n)，其中n是字符串的长度。
     * <p>
     * 空间复杂度：额外使用了一个存储前缀和的数组，长度为 n+1n+1n+1，因此空间复杂度为 O(n)O(n)O(n)。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            solution(str);
        }
    }

    private static void solution(String str) {
        int n = str.length();

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + str.charAt(i);
        }

        int i = 1, j = 2;
        while (j < n) {
            int asciiSumI = prefixSum[i] - prefixSum[0];
            int asciiSumJ = prefixSum[j] - prefixSum[i + 1];
            int asciiSumK = prefixSum[n] - prefixSum[j + 1];

            if (asciiSumI == asciiSumJ && asciiSumJ == asciiSumK) {
                System.out.println(i + "," + j);
                return;
            }

            if (asciiSumI <= asciiSumJ) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("0,0");
    }
}
