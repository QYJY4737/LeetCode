package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test007 {
    /**
     * 题目0007-单词反转
     * 题目描述
     * 输入一个英文文章片段，
     * 翻转指定区域的单词顺序，
     * 标点符号和普通字母一样处理，
     * 例如输入字符串
     * I am a developer.
     * [0,3]
     * 则输出
     * developer. a am I
     * <p>
     * 输入描述
     * 使用换行隔开3个参数
     * 第一个参数为文章内容 即英文字符串
     * 第二个参数为翻转起始单词下标，下标从0开始
     * 第三个参数为结束单词下标
     * <p>
     * 输出描述
     * 翻转后英文文章片段每个单词之间以一个半角空格分割输出
     * <p>
     * 示例一
     * 输入
     * I am a developer.
     * 0
     * 3
     * 输出
     * developer. a am I
     * 示例二
     * 输入
     * hello world!
     * 0
     * 3
     * 输出
     * world! hello
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            solution(line, l, r);
        }
    }

    private static void solution(String line, int l, int r) {
        String[] words = line.trim().split(" ");
        if (r > words.length - 1) r = words.length - 1;
        if (words.length == 0 ||
                l < 0 ||
                r - l <= 0) {
            System.out.println("EMPTY");
            return;
        }

        while (l < r) {
            String tmp = words[l];
            words[l] = words[r];
            words[r] = tmp;
            l++;
            r--;
        }

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i != words.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
