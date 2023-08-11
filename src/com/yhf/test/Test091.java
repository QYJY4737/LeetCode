package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test091 {
    /**
     * 题目0091-单词反转2
     * 题目描述
     * 给定一段英文文章片段，由若干单词组成，单词间以空格间隔，单词下标从0开始。
     * 请翻转片段中指定区域的单词顺序并返回翻转后的内容。
     * 例如给定的英文文章片段为I am a developer,
     * 翻转区间为[0,3],则输出developer a am I。
     * String reverseWords(String s, int start, int end).
     * <p>
     * 输入描述
     * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，
     * 第二个参数为待反转内容起始单词下标，
     * 第三个参数为待翻转内容最后一个单词下标。
     * <p>
     * 输出描述
     * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出。
     * <p>
     * 示例一
     * 输入
     * I am a developer
     * 1
     * 2
     * 输出
     * I a am developer
     * 说明
     * 示例二
     * 输入
     * Hello world
     * -1
     * 1
     * 输出
     * world Hello
     * 说明
     * 下标小于0时从第一个单词开始
     * <p>
     * 示例三
     * 输入
     * I am a developer
     * 0
     * 5
     * 输出
     * developer a am I
     * 说明
     * 下标大于实际单词个数，则按最大下标算。
     * <p>
     * 示例四
     * 输入
     * I am a developer
     * -2
     * -1
     * 输出
     * I am a developer
     * 说明
     * 翻转区间无效时不做翻转。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            solution(line, start, end);
        }
    }

    private static void solution(String line, int start, int end) {
        String[] words = line.split(" ");
        if (start > end || start > words.length - 1 || end < 0) {
            System.out.println(line);
            return;
        }
        int l = Math.max(0, start);
        int r = Math.min(words.length - 1, end);
        while (l <= r) {
            String tmp = words[l];
            words[l] = words[r];
            words[r] = tmp;
            l++;
            r--;
        }
        for (String word : words) {
            System.out.print(word + " ");
        }
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i != words.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
