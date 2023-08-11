package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test077 {
    /**
     * 题目0077-环中最长子串
     * 题目描述
     * 给你一个字符串s,首尾相连成一个环形,
     * 请你在环中找出o字符出现了偶数次最长子字符串的长度.
     * 备注:
     * 1 <= s.lenth <= 5x10^5
     * s只包含小写英文字母
     * <p>
     * 输入描述
     * 输入是一个小写字母组成的字符串
     * <p>
     * 输出描述
     * 输出是一个整数
     * <p>
     * 示例一
     * 输入
     * alolobo
     * 输出
     * 6
     * 说明
     * 最长子字符串之一是alolob,它包含2个o
     * <p>
     * 示例二
     * 输入
     * looxdolx
     * 输出
     * 7
     * 说明
     * 最长子字符串oxdolxl,由于是首尾连接一起的,
     * 所以最后一个x和开头的l是连接在一起的此字符串包含2个o
     * <p>
     * 示例三
     * 输入
     * bcbcbc
     * 输出
     * 6
     * 说明
     * 这个示例中,字符串bcbcbc本身就是最长的,
     * 因为o都出现了0次
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        int max = 0;
        for (int i = 0; i < line.length(); i++) {
            String str = line.substring(i) + line.substring(0, i);
            for (int j = 0; j < str.length(); j++) {
                String sub = str.substring(0, i + 1);
                int count = countO(sub);
                if (count % 2 == 0 && sub.length() > max) {
                    max = sub.length();
                    break;
                }
            }
        }
        System.out.print(max);
    }

    private static int countO(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'o') count++;
        }
        return count;
    }
}
