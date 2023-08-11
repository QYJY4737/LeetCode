package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test058 {
    /**
     * 题目0058-连续子串
     * 题目描述
     * 给你两个字符串t和p
     * 要求从t中找到一个和p相同的连续子串
     * 并输出该子串第一个字符的下标
     * <p>
     * 输入描述
     * 输入文件包括两行 分别表示字符串t和p
     * 保证t的长度不小于p
     * 且t的长度不超过1000000
     * p的长度不超过10000
     * <p>
     * 输出描述
     * 如果能从t中找到一个和p相等的连续子串,
     * 则输出该子串第一个字符在t中的下标
     * 下标从左到右依次为1,2,3,...
     * 如果不能则输出 No
     * 如果含有多个这样的子串
     * 则输出第一个字符下标最小的
     * <p>
     * 示例一
     * 输入
     * AVERDXIVYERDIAN
     * RDXI
     * 输出
     * 4
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String t = scanner.nextLine();
            String p = scanner.nextLine();
            solution(t, p);
        }

    }

    private static void solution(String t, String p) {
        int len = p.length();
        for (int i = 0; i <= t.length() - len; i++) {
            String substring = t.substring(i, i + len);
            if (substring.equals(p)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("No");
    }
}
