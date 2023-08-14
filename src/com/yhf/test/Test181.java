package com.yhf.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test181 {
    /**
     * 题目0181-单词倒序
     * 题目描述
     * 输入单行英文句子，里面包含英文字母，空格以及, . ? 三种标点符号，
     * 请将句子内每个单词进行倒序，并输出倒序后的语句。
     * <p>
     * 输入描述
     * 输入字符串S，S的长度1 <= N <= 100
     * <p>
     * 输出描述
     * 输出逆序后的字符串
     * <p>
     * 备注
     * 标点符号左右的空格 >= 0，单词间空格 > 0
     * <p>
     * 示例一
     * 输入
     * yM eman si boB.
     * 输出
     * My name is Bob.
     * 示例二
     * 输入
     * woh era uoy ? I ma enif.
     * 输出
     * how are you ? I am fine.
     * 思路
     * 遍历字符串，遇到非符号压入栈；遇到符号，将栈中元素全部出栈覆盖原有字符串，并跳过符号开始需要下一个乱序单词。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String res = solution(line);
            System.out.println(res);
        }
    }

    private static String solution(String line) {
        char[] chars = line.trim().toCharArray();
        Stack<Character> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == ' ' || cur == '?' || cur == ',' || cur == '.') {
                for (int j = start; j < i; j++) {
                    chars[j] = stack.pop();
                }
                start = i + 1;
                if (cur != ' ') {
                    start++;
                }
            } else {
                stack.push(cur);
            }
        }
        for (int j = start; j < chars.length; j++) {
            chars[j] = stack.pop();
        }
        return new String(chars);
    }
}
