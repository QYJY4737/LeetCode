package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test199 {
    /**
     * 题目0199-数字加减游戏
     * 页面内容
     * 讨论
     * 最后编辑
     * Amos
     * 01/16/2023
     * 数字加减游戏
     * 题目描述
     * 小明在玩一个数字加减游戏，只使用加法或者减法，将一个数字s变成数字t。
     * 每个回合，小明可以用当前的数字加上或减去一个数字。
     * 现在有两种数字可以用来加减，分别为a,b(a!=b)，其中b没有使用次数限制。
     * 请问小明最少可以用多少次a，才能将数字s变成数字t。
     * 题目保证数字s一定能变成数字t。
     * <p>
     * 输入描述
     * 输入的唯一一行包含四个正整数s,t,a,b
     * (1≤s,t,a,b≤1051 \leq s,t,a,b \leq 10^51≤s,t,a,b≤10
     * 5
     * )，并且a != b。
     * <p>
     * 输出描述
     * 输出的唯一一行包含一个整数，表示最少需要使用多少次a才能将数字s变成数字t。
     * <p>
     * 示例一
     * 输入
     * 1 10 5 2
     * 输出
     * 1
     * 说明
     * 初始值1加一次a变成6，然后加两次b变为10，因此a的使用次数为1次。
     * <p>
     * 示例二
     * 输入
     * 11 33 4 10
     * 输出
     * 2
     * 说明
     * 11减两次a变成3，然后加三次b变为33，因此a的使用次数为2次。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = solution(s, t, a, b);
            System.out.print(res);
        }
    }

    private static int solution(int s, int t, int a, int b) {
        int diff = Math.abs(s - t);
        int min1 = 0;
        int tmp = diff;
        while (tmp % b != 0) {
            tmp -= a;
            min1++;
        }

        tmp = diff;
        int min2 = 0;
        while (tmp % b != 0) {
            tmp += a;
            min2++;
        }

        return Math.min(min1, min2);
    }
}
