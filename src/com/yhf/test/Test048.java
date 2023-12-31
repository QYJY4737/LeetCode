package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test048 {
    /**
     * 题目0048-分糖果
     * 题目描述
     * 小明从糖果盒中随意抓一把糖果
     * 每次小明会取出一半的糖果分给同学们
     * 当糖果不能平均分配时
     * 小明可以从糖果盒中(假设盒中糖果足够)取出一个或放回一个糖果
     * 小明至少需要多少次(取出放回和平均分配均记一次)能将手中糖果分至只剩一颗
     * <p>
     * 输入描述
     * 抓取糖果数(小于1000000)，例如15
     * <p>
     * 输出描述
     * 最少分至一颗糖果的次数，例如5
     * <p>
     * 示例一
     * 输入
     * 15
     * 输出
     * 5
     * 说明
     * 解释：
     * <p>
     * 15+1=16
     * 16/2=8
     * 8/2=4
     * 4/2=2
     * 2/2=1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = Integer.parseInt(scanner.nextLine());
            solution(x);
        }
    }

    private static void solution(int x) {
        int count = 0;
        for (int i = x; i != 1; i /= 2, count++) {
            if (i == 3) {
                count += 2;
                break;
            }
            if (i % 2 != 0) {
                if ((i + 1) / 2 % 2 == 0) i++;
                else i--;
                count++;
            }
        }
        System.out.print(count);
    }
}
