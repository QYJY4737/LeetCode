package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test178 {
    /**
     * 题目0178-不含101的数
     * 题目描述
     * 小明在学习二进制时，发现了一类不含 101101101 的数，
     * 也就是将数字用二进制表示，不能出现 101101101 。
     * 现在给定一个正整数区间 [l,r][l,r][l,r]，请问这个区间内包含了多少个不含 101101101 的数？
     *
     * 输入描述
     * 输入一行，包含两个正整数 l,r(1≤l<r≤109)l,r (1 \leq l < r \leq 10^9)l,r(1≤l<r≤10
     * 9
     *  ) 。
     *
     * 输出描述
     * 输出一行包含一个整数，表示在 [l,r][l,r][l,r] 区间内一共有多少个不含 101101101 的数。
     *
     * 示例一
     * 输入
     * 1 10
     * 输出
     * 8
     * 说明
     * 区间[1,10]内，5的二进制表示为101,10的二进制表达式为1010,因此出了5与10不满足条件外，其他数字都满足条件，因此答案为8。
     *
     * 示例二
     * 输入
     * 10 20
     * 输出
     * 7
     * 说明
     * 区间[10,20]内，满足条件的数字有[12,14,15,16,17,18,19]，因此答案为7。
     *
     * 思路
     * 数字n最低三位为101，即n ^ 5（n异或5等于0），
     * 将每个数字逐位右移并异或运算即可检测是否存在二进制101。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int res = solution(l, r);
            System.out.println(res);
        }
    }

    private static final int x = 0b0111_1111_1111_1111_1111_1111_1111_1000;

    private static int solution(int l, int r) {
        int count = 0;

        for (int i = l; i <= r; i++) {
            int n = i;
            while (n >= 5) {
                if (((x | n) - x ^ 5) == 0) {
                    count++;
                    break;
                }
                n >>= 1;
            }
        }
        return r - l + 1 - count;
    }

}
