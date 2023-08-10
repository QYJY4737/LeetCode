package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test047 {
    /**
     * 题目0047-求字符串中所有整数的最小和
     * 题目描述
     * 说明
     * <p>
     * 字符串s，只包含 a-z A-Z + - ；
     * 合法的整数包括
     * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
     * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
     * 输入描述
     * 包含数字的字符串
     * <p>
     * 输出描述
     * 所有整数的最小和
     * <p>
     * 示例一
     * 输入
     * bb1234aa
     * 输出
     * 10
     * 示例二
     * 输入
     * bb12-34aa
     * 输出
     * -31
     * 说明
     * 1+2+(-34) = 31
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int sum = solution(line);
            System.out.println(sum);
        }
    }

    private static int solution(String line) {
        char[] chars = line.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '-') {
                i++;
                int start = i;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    i++;
                }
                String substring = line.substring(start, i);
                if (substring.length() > 0) {
                    sum -= Integer.parseInt(substring);
                }
                i--;
                continue;
            }
            if (Character.isDigit(c)) {
                sum += Character.digit(c, 10);
            }
        }
        return sum;
    }
}
