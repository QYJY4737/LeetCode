package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test147 {
    /**
     * 题目0147-挑选字符串
     * 题目描述
     * 给定a-z，26个英文字母小写字符串组成的字符串A和B，
     * 其中A可能存在重复字母，B不会存在重复字母，
     * 现从字符串A中按规则挑选一些字母可以组成字符串B
     * 挑选规则如下：
     * 同一个位置的字母只能挑选一次，
     * 被挑选字母的相对先后顺序不能被改变，
     * 求最多可以同时从A中挑选多少组能组成B的字符串
     *
     * 输入描述
     * 输入为2行，
     * 第一行输入字符串a,
     * 第二行输入字符串b，
     * 行首行尾没有多余空格
     *
     * 输出描述
     * 输出一行
     * 包含一个数字表示最多可以同时从a中挑选多少组能组成b的字符串，
     * 行末没有多余空格
     *
     * 示例一
     * 输入
     * badc
     * bac
     * 输出
     * 1
     * 说明
     * 示例二
     * 输入
     * badc
     * abc
     * 输出
     * 0
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int res = solution(a, b);
            System.out.print(res);
        }
    }

    private static int solution(String a, String b) {
        int count = 0;
        while (true) {
            char[] chars = b.toCharArray();
            int last = 0;
            for (char c : chars) {
                int index = a.indexOf(c, last);
                last = index;
                if (index != -1) {
                    a = a.replaceFirst(c + "", "_");
                } else {
                    return count;
                }
            }
            count++;
        }
    }
}
