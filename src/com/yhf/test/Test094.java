package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test094 {
    /**
     * 题目0094-字符串加密
     * 题目描述
     * 给你一串未加密的字符串str，
     * 通过对字符串的每一个字母进行改变来实现加密，
     * 加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，
     * 数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
     * 当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]，
     * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
     *
     * 输入描述
     * 第一行为一个整数n（1 <= n <= 1000），
     * 表示有n组测试数据，每组数据包含一行，
     * 原文str（只含有小写字母， 0 < 长度 <= 50）。
     *
     * 输出描述
     * 每组测试数据输出一行，表示字符串的密文
     *
     * 示例一
     * 输入
     * 1
     * xy
     * 输出
     * ya
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }
            solution(strings);
        }
    }

    private static void solution(String[] strings) {
        int[] a = {1, 2, 4};
        long[] offsets = new long[50];
        for (int i = 0; i < offsets.length; i++) {
            if (i < 3) {
                offsets[i] = a[i];
            } else {
                offsets[i] = offsets[i - 1] + offsets[i - 2] + offsets[i - 3];
            }
        }

        for (String str : strings) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                chars[i] = (char) ((c - 97 + offsets[i]) % 26 + 97);
            }
            System.out.println(new String(chars));
        }
    }
}
