package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test138 {
    /**
     * 题目0138-最长连续子串
     * 题目描述
     * 给定一个字符串 只包含字母和数字
     * 按要求找出字符串中的最长连续子串的长度
     * 字符串本身是其最长的子串
     * 子串要求
     *
     * 只包含一个字母(a~z A~Z)其余必须是数字
     * 字母可以在子串中的任意位置
     * 如果找不到满足要求的子串 比如说，全是字母或数字则返回-1
     * 输入描述
     * 字符串只包含字母和数字
     *
     * 输出描述
     * 子串的长度
     *
     * 示例一
     * 输入
     * abC124ACb
     * 输出
     * 4
     * 说明
     * 满足条件的最长子串是C124或者124A
     * 长度都是4
     *
     * 示例二
     * 输入
     * a5
     * 输出
     * 2
     * 说明
     * 自身就是满足条件的子串长度为2
     *
     * 示例三
     * 输入
     * aBB9
     * 输出
     * 2
     * 说明
     * 说明满足条件的子串为B9
     *
     * 示例四
     * 输入
     * abcdef
     * 输出
     * -1
     * 说明
     * 没有满足要求的子串，返回-1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            solution(str);
        }
    }

    private static void solution(String str) {

        int left = 0;
        int right = 1;
        int max = -1;
        while (left < str.length() && right < str.length()) {
            right++;
            String subStr = str.substring(left, right);
            if (check(subStr)) {
                max = Math.max(max, subStr.length());
            } else {
                left++;
            }
        }
        System.out.println(max);
    }

    private static boolean check(String str) {
        String replace = str.replaceAll("[0-9]", "");
        return replace.length() != str.length() && replace.length() <= 1;
    }
}
