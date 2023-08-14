package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test177 {
    /**
     * 题目0177-找出重复代码
     * 题目描述
     * 小明负责维护项目下的代码，需要查找出重复代码，用以支撑后续的代码优化，请你帮助小明找出重复的代码。
     * 重复代码查找方法：以字符串形式给出两行代码（字符串长度1 < length <= 100，由英文字母、数字和空格组成），找出两行代码中的最长公共子串。
     * 注：如果不存在公共子串，返回空字符串。
     * <p>
     * 输入描述
     * 输入的参数text1，text2分别表示两行代码
     * <p>
     * 输出描述
     * 输出任一最长公共子串
     * <p>
     * 示例一
     * 输入
     * hello123world
     * hello123abc4
     * 输出
     * hello123
     * 示例二
     * 输入
     * private_void_method
     * public_void_method
     * 输出
     * _void_method
     * 示例三
     * 输入
     * hiworld
     * hiweb
     * 输出
     * hiw
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String text1 = scanner.nextLine();
            String text2 = scanner.nextLine();
            String res = solution(text1, text2);
            System.out.println(res);
        }
    }

    private static String solution(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        int maxLen = 0;
        int lastPos = 0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                        lastPos = i;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return "";
        } else {
            return text1.substring(lastPos - maxLen + 1, lastPos + 1);
        }
    }
}
