package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test127 {
    /**
     * 题目0127-最长连续交替方波信号
     * 题目描述
     * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，
     * 如果有相同长度的交替方波信号，输出任一即可，方波信号高位用1标识，低位用0标识
     * 如图：
     * 说明：
     *
     * 一个完整的信号一定以0开始然后以0结尾，
     * 即010是一个完整的信号，但101，1010，0101不是
     * 输入的一串方波信号是由一个或多个完整信号组成
     * 两个相邻信号之间可能有0个或多个低位，如0110010，011000010
     * 同一个信号中可以有连续的高位，如01110101011110001010
     * 前14为是一个具有连续高位的信号
     * 完全连续交替方波是指10交替，如01010是完全连续交替方波，0110不是
     * 输入描述
     * 输入信号字符串(长度 大于等于3 且 小于等于 1024)
     * 注：输入总是合法的，不考虑异常情况
     *
     * 输出描述
     * 输出最长的完全连续交替方波信号串
     * 若不存在完全连续交替方波信号串 输出-1
     *
     * 示例一
     * 输入
     * 0010101010110000101000010
     * 输出
     * 01010
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String in = scanner.nextLine();
            solution(in);
        }
    }

    private static void solution(String in) {
        char[] bits = in.toCharArray();

        List<String> waves = new LinkedList<>();

        int first = in.indexOf("1");
        int last = in.lastIndexOf("1");
        for (int i = first; i <= last; i++) {
            if (i + 1 < bits.length &&
                    bits[i] == '0' &&
                    bits[i + 1] == '0') {
                waves.add(in.substring(first - 1, i + 1));

                while (bits[i] == '0') {
                    i++;
                }
                first = i;
            }
        }

        waves.add(in.substring(first - 1, last + 2));


        List<String> res = new LinkedList<>();

        for (String wave : waves) {
            int n0 = 0, n1 = 0;
            for (char c : wave.toCharArray()) {
                if (c == '0') n0++;
                else n1++;
            }
            if (n0 - n1 == 1) {
                res.add(wave);
            }
        }

        res.sort((w1, w2) -> w2.length() - w1.length());
        if (res.size() > 0) {
            System.out.print(res.get(0));
        } else {
            System.out.print(-1);
        }
    }
}
