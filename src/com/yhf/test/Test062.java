package com.yhf.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test062 {
    /**
     * 题目0062-RSA加密算法
     * 题目描述
     * RSA加密算法在网络安全世界中无处不在
     * 它利用了极大整数因数分解的困难度，数据越大安全系数越高
     * 给定了一个32位正整数，请对其进行因数分解
     * 找出哪两个素数的乘积
     * <p>
     * 输入描述
     * 一个正整数num
     * 0 < num <= 2147483647
     * <p>
     * 输出描述
     * 如果成功找到以单个空格分割
     * 从小到大输出两个素数
     * 分解失败请输出-1 -1
     * <p>
     * 示例一
     * 输入
     * 15
     * 输出
     * 3 5
     * 说明
     * 因数分解后3 * 5 = 15
     * 从小到大后输出 3 5
     * <p>
     * 示例二
     * 输入
     * 27
     * 输出
     * -1 -1
     * 说明
     * 通过因数分解，找不到任何素数使他们的乘积为27
     * 因此输出-1 -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        Set<Integer> factors = new HashSet<>();
        int tmp = num;
        int f = 2;
        while (tmp != 1) {
            if (tmp % f != 0) {
                f++;
            } else {
                factors.add(f);
                tmp /= f;
            }
        }
        for (Integer f1 : factors) {
            for (Integer f2 : factors) {
                if (f1 * f2 == num) {
                    int min = Math.min(f1, f2);
                    int max = Math.max(f1, f2);
                    System.out.print(min + " " + max);
                    return;
                }
            }
        }
        System.out.print("-1 -1");
    }
}
