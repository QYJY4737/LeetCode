package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test046 {
    /**
     * 题目0046-乘积最大值
     * 题目描述
     * 给定一个元素类型为小写字符串的数组
     * 请计算两个没有相同字符的元素长度乘积的最大值
     * 如果没有符合条件的两个元素返回0
     * <p>
     * 输入描述
     * 输入为一个半角逗号分割的小写字符串数组
     * 2 <= 数组长度 <= 100
     * 0 < 字符串长度 <= 50
     * <p>
     * 输出描述
     * 两个没有相同字符的元素长度乘积的最大值
     * <p>
     * 示例一
     * 输入
     * iwdvpbn,hk,iuop,iikd,kadgpf
     * 输出
     * 14
     * 说明
     * 数组中有5个元组 第一个和第二个元素没有相同字符
     * 满足条件 输出7 * 2 = 14
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(",");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i; j < split.length; j++) {
                char[] chars = split[j].toCharArray();
                int k = 0;
                while (k < chars.length) {
                    if (split[i].indexOf(chars[k]) != -1) break;
                    k++;
                }
                int tmp = split[i].length() * split[j].length();
                if (k == chars.length && tmp > max) max = tmp;
            }
        }
        System.out.print(max);
    }
}
