package com.yhf.test1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test249 {
    /**
     * 题目0249-全排列
     * 题目描述
     * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
     * <p>
     * 如：S为ABA，则不同的排列有ABA、AAB、BAA三种。
     * <p>
     * 输入描述
     * 输入一个长度不超过10的字符串S，我们确保都是大写的。
     * <p>
     * 输出描述
     * 输出S重新排列的所有不相同的排列数（包含自己本身）。
     * <p>
     * 示例一
     * 输入
     * ABA
     * 输出
     * 3
     * 示例二
     * 输入
     * ABCDEFGHHA
     * 输出
     * 907200
     * ¶思路解析和复杂度分析
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'A']++;
            }
            BigInteger res = factorial(s.length());
            for (int f : freq) {
                if (f > 1) {
                    res = res.divide(factorial(f));
                }
            }
            System.out.println(res);
        }

    }

    public static BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
