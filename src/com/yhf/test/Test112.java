package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test112 {
    /**
     * 题目0112-旋转骰子
     * 题目描述
     * 骰子是一个正方体，每个面有一个数字，初始为左1，右2，前3，后4，上5，下6，
     * 用123456表示这个状态，放置在平面上，
     * 可以向左翻转（用L表示向左翻转1次）；
     * 可以向右翻转（用R表示向右翻转1次）；
     * 可以向前翻转（用F表示向前翻转1次）；
     * 可以向后翻转（用B表示向后翻转1次）；
     * 可以逆时针翻转（用A表示向逆时针翻转1次）；
     * 可以向顺时针翻转（用C表示向顺时针翻转1次）；
     * 现从123456这个初始状态开始，根据输入的动作序列 计算最终的状态
     *
     * 输入描述
     * 输出描述
     * 示例一
     * 输入
     * LR
     * 输出
     * 123456
     * 说明
     * 示例二
     * 输入
     * FCR
     * 输出
     * 342156
     */

    static StringBuilder res = new StringBuilder("123456");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        for (char c : line.toCharArray()) {
            switch (c) {
                case 'L':
                    roll(0, 2, 4, 6);
                    break;
                case 'R':
                    roll(4, 6, 0, 2);
                    break;
                case 'F':
                    roll(2, 4, 4, 6);
                    break;
                case 'B':
                    roll(4, 6, 2, 4);
                    break;
                case 'A':
                    roll(2, 4, 0, 2);
                    break;
                case 'C':
                    roll(0, 2, 2, 4);
                    break;
            }
        }
        System.out.print(res);
    }

    private static void roll(int s1, int e1, int s2, int e2) {
        String tmp = new StringBuilder(res.substring(s1, e1))
                .reverse().toString();
        res.replace(s1, e1, res.substring(s2, e2))
                .replace(s2, e2, tmp);
    }
}
