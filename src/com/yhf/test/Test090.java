package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test090 {
    /**
     * 题目0090-有效子字符串
     * 题目描述
     * 输入两个字符串S和L，都只包含小写字母，
     * S长度 <= 100,L长度 <= 500000，
     * 判断S是否是L的有效子字符串，
     * 判定规则：S中的每个字符在L中都能找到（可以不连续）
     * 且S在L中字符的前后顺序与S中顺序要保持一致
     * 例如：
     * S="ace"是L="abcde"的一个子序列
     * 且有效字符是a、c、e，
     * 而"aec"不是有效子序列，且有效字符只有a、e。
     * <p>
     * 输入描述
     * 输入两个字符串S和L，都只包含小写字母，
     * S长度 <= 100,L长度 <= 500000，
     * 先输入S再输入L
     * 每个字符串占一行
     * <p>
     * 输出描述
     * S串最后一个有效字符在L中的位置
     * 首位从0开始计算
     * 无有效字符返回-1
     * <p>
     * 示例一
     * 输入
     * acce
     * abcde
     * 输出
     * 4
     * 示例二
     * 输入
     * fgh
     * abcde
     * 输出
     * -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String S = scanner.nextLine();
            String L = scanner.nextLine();
            solution(S, L);
        }
    }

    public static void solution(String s, String l) {
        int n = s.length(), m = l.length();
        int i = 0, j = 0;
        int pos = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == l.charAt(j)) {
                pos = j;
                i++;
            }
            j++;
        }
        if (i == n) {
            System.out.println(pos);
        } else {
            System.out.println(-1);
        }
    }
}
