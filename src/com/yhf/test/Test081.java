package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test081 {
    /**
     * 题目0081-新工号系统
     * 题目描述
     * 3020年空间通信集团的员工突破20亿人，即将遇到现有工号不够的窘境。
     * 现在你负责调研新工号系统，继承历史传统
     * 新的工号系统由小写英文字母a-z和数字0-9两部分构成。
     * 新工号由一段英文字母开头。之后跟随一段数字，比如
     * aaahw0001,a12345,abcd1,a00.
     * 注意：新工号不能全为字母或数字，允许数字部分有前导0或者全为0。
     * 但是过长的工号会增加同事们的记忆成本，
     * 现在给出新工号 至少需要分派的人数x
     * 和新工号中字母的长度y，
     * 求新工号中数字的最短长度z.
     *
     * 输入描述
     * 一行两个非负整数x y,数字用单个空格分隔。
     * 0 < x <= 2^50-1
     * 0 < y <= 5
     *
     * 输出描述
     * 输出新工号中数字的最短长度z
     *
     * 示例一
     * 输入
     * 260 1
     * 输出
     * 1
     * 示例二
     * 输入
     * 26 1
     * 输出
     * 1
     * 说明
     * 数字长度不能为零
     *
     * 示例三
     * 输入
     * 2600 1
     * 输出
     * 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        double x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);

        double cb = Math.pow(26, y);

        if (cb > x) {
            System.out.print(1);
        } else {
            int i = 1;
            while (cb * (Math.pow(10, i)) < x) {
                i++;
            }
            System.out.print(i);
        }
    }
}
