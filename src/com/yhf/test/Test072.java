package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test072 {
    /**
     * 题目0072-相同字符连续出现的最大次数
     * 题目描述
     * 输入一串字符串
     * 字符串长度不超过100
     * 查找字符串中相同字符连续出现的最大次数
     * <p>
     * 输入描述
     * 输入只有一行，包含一个长度不超过100的字符串
     * <p>
     * 输出描述
     * 输出只有一行，输出相同字符串连续出现的最大次数
     * <p>
     * 示例一
     * 输入
     * hello
     * 输出
     * 2
     * 示例二
     * 输入
     * word
     * 输出
     * 1
     * 示例三
     * 输入
     * aaabbc
     * 输出
     * 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        char[] chars = line.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = i;
            int len = 1;
            while (index + 1 < chars.length && chars[index + 1] == chars[index]) {
                len++;
                index++;
            }
            if (len > maxLen) maxLen = len;
        }
        System.out.print(maxLen);
    }
}
