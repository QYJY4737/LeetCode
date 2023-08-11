package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test055 {
    /**
     * 题目0055-GPU调度
     * 题目描述
     * 为了充分发挥GPU算力，
     * 需要尽可能多的将任务交给GPU执行，
     * 现在有一个任务数组，
     * 数组元素表示在这1s内新增的任务个数，
     * 且每秒都有新增任务，
     * 假设GPU最多一次执行n个任务，
     * 一次执行耗时1s，
     * 在保证GPU不空闲的情况下，最少需要多长时间执行完成。
     * <p>
     * 输入描述
     * 第一个参数为GPU最多执行的任务个数
     * 取值范围1 ~ 10000
     * 第二个参数为任务数组的长度
     * 取值范围1 ~ 10000
     * 第三个参数为任务数组
     * 数字范围1 ~ 10000
     * <p>
     * 输出描述
     * 执行完所有任务需要多少秒
     * <p>
     * 示例一
     * 输入
     * 3
     * 5
     * 1 2 3 4 5
     * 输出
     * 6
     * 说明
     * 一次最多执行3个任务
     * 最少耗时6s
     * <p>
     * 示例二
     * 输入
     * 4
     * 5
     * 5 4 1 1 1
     * 输出
     * 5
     * 说明
     * 一次最多执行4个任务
     * 最少耗时5s
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int len = scanner.nextInt();
            int[] jobs = new int[len];
            for (int i = 0; i < len; i++) {
                jobs[i] = scanner.nextInt();
            }
            solution(n, jobs);
        }
    }

    private static void solution(int n, int[] jobs) {
        int time = 0;
        int more = 0;
        for (int i : jobs) {
            if (i + more > n) more = i + more - n;
            else more = 0;
            time++;
        }
        while (more > 0) {
            more -= n;
            time++;
        }
        System.out.print(time);
    }
}
