package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test122 {
    /**
     * 题目0122-高效的任务规划
     * 题目描述
     * 你有n台机器编号为1-n，每台都需要完成一项工作，
     * 机器经过配置后都能独立完成一项工作。
     * 假设第i台机器你需要花Bi分钟进行设置，
     * 然后开始运行，Ji分钟后完成任务。
     * 现在，你需要选择布置工作的顺序，使得用最短的时间完成所有工作。
     * 注意，不能同时对两台进行配置，
     * 但配置完成的机器们可以同时执行他们各自的工作。
     *
     * 输入描述
     * 第一行输入代表总共有M组任务数据(1 < M <= 10);
     * 每组数第一行为一个整数指定机器的数量N(0 < N <= 1000)。
     * 随后的N行每行两个整数，第一个表示B(0 <= B <= 10000),
     * 第二个表示J(0 <= J <= 10000);
     * 每组数据连续输入，不会用空行分割，各组任务单独计时
     *
     * 输出描述
     * 对于每组任务，输出最短完成时间，
     * 且每组的结果独占一行。
     * 例如两组任务就应该有两行输出。
     *
     * 示例一
     * 输入
     * 1
     * 1
     * 2 2
     * 输出
     * 4
     * 说明
     * 输入共3行数据，
     * 第一行代表只有1组任务；
     * 第二行代表本组任务只有1台机器；
     * 第三行代表本机器：配置需要2分钟，执行任务需要2分钟，
     * 输出共一行数据，代表执行结果为4分钟
     *
     * 示例一
     * 输入
     * 2
     * 2
     * 1 1
     * 2 2
     * 3
     * 1 1
     * 2 2
     * 3 3
     * 输出
     * 4
     * 7
     * 说明
     * 第1行 2代表有2组任务；
     * 2~4行代表第1组数据，为2台机器的配置、执行信息
     * 第1台：配置1分钟，执行1分钟
     * 第2台：配置2分钟，执行2分钟
     * 5~8行代表第2组数据，为3台机器的配置、执行信息
     * 第1台：配置1分钟，执行1分钟
     * 第2台：配置2分钟，执行2分钟
     * 第3台：配置3分钟，执行3分钟
     * 输出共2行，分别代表第1组任务共需要4分钟和第2组任务共需要7分钟
     * 先配置3，再配置2，再配置1，执行1分钟，共7分钟
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int M = scanner.nextInt();
            for (int i = 0; i < M; i++) {
                int N = scanner.nextInt();
                int[][] jobs = new int[N][2];
                for (int j = 0; j < N; j++) {
                    jobs[j][0] = scanner.nextInt();
                    jobs[j][1] = scanner.nextInt();
                }

                solution(jobs);
            }
        }
    }

    private static void solution(int[][] jobs) {
        Arrays.sort(jobs, (job1, job2) -> job2[1] - job1[1]);

        int time = 0;
        int remaining = 0;

        for (int[] job : jobs) {
            // 添加配置时间
            time += job[0];
            remaining -= job[0];

            if (remaining <= 0) {
                remaining = job[1];
            } else {
                remaining = remaining - job[0] + job[1];
            }
        }

        time += remaining;
        System.out.println(time);
    }
}
