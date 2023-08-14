package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test110 {
    /**
     * 题目0110-吃火锅
     * 题目描述
     * 入职后，导师会请你吃饭，你选择了火锅，
     * 火锅里会在不同时间下很多菜，
     * 不同食材要煮不同时间，才能变得刚好合适，
     * 你希望吃到最多的刚好合适的菜，
     * 但是你的手速不够快用m代替手速，
     * 每次下手捞菜后至少要过m秒，
     * 才能再捞（每次只能捞一个）那么用最合理的策略，
     * 最多能吃到多少，刚好合适的菜
     *
     * 输入描述
     * 第一行两个整数n，m
     * 其中n代表往锅里下菜的个数
     * m代表手速
     * 接下来有n行，
     * 每行有两个数x，y
     * 代表第x秒下的菜过y秒才能变得刚好合适（1 < mn < 1000），（1 < xy < 1000）
     *
     * 输出描述
     * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量
     *
     * 示例一
     * 输入
     * 2 1
     * 1 2
     * 2 1
     * 输出
     * 1
     * 说明
     * 一共下了两个菜，在第一秒下的菜，需要到第三秒吃。
     * 在第二秒下的菜，也要到第三秒吃，所以只能吃一个
     *
     * 示例二
     * 输入
     * 3 1
     * 1 2
     * 1 3
     * 2 3
     * 输出
     * 3
     * 说明
     * 一共下了三个菜，每秒捞一个，第一个在第一秒下的菜，
     * 需要到第三秒吃，第二个在第一秒下的菜需要到第四秒吃，
     * 在第二秒下的菜，需要到第五妙吃，所以三个都能吃
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            solution(n, m, x, y);
        }

    }

    private static void solution(int n, int m, int[] x, int[] y) {

        int[] arrTime = new int[n];
        for (int i = 0; i < n; i++) {
            arrTime[i] = x[i] + y[i];
        }

        Arrays.sort(arrTime);


        int[] arrCount = new int[n];

        int next = 0;
        arrCount[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arrTime[i] >= (arrTime[next] + m)) {
                arrCount[i] = 1;
                next = i;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arrCount[i] > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
