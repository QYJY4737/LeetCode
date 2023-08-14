package com.yhf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test175 {
    /**
     * 题目0175-任务混部
     * 题目描述
     * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，请你设计算法帮他们解决一个任务混部问题：有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime），并行度（parallelism）三个属性，并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完会立即释放（结束时刻不占用）。任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，请你计算完成这批任务混部最少需要多少服务器，从而最大化控制资源成本。
     * <p>
     * 输入描述
     * 第一行输入为taskNum，表示有taskNum项任务
     * 接下来taskNum行，每行三个整数，表示每个任务的开始时间(startTime)，结束时间(endTime)，并行度(parallelism)
     * <p>
     * 输出描述
     * 一个整数，表示最少需要的服务器数量
     * <p>
     * 示例一
     * 输入
     * 3
     * 2 3 1
     * 6 9 2
     * 0 5 1
     * 输出
     * 2
     * 说明
     * 一共有三个任务，
     * 第一个任务在时间区间[2，3)运行，占用1个服务器，
     * 第二个任务在时间区间[6,9)运行，占用2个服务器，
     * 第二个任务在时间区间[0,5)运行，占用1个服务器，
     * 需要最多服务器的时间区间为[2，3)和[6,9)，需要2个服务器。
     * <p>
     * 示例二
     * 输入
     * 2
     * 3 9 2
     * 4 7 3
     * 输出
     * 5
     * 说明
     * 一共有两个任务，
     * 第一个任务在时间区间[3，9)运行，占用2个服务器，
     * 第二个任务在时间区间[4,7)运行，占用3个服务器，
     * 需要最多服务器的时间区间为[4，7)，需要5个服务器。
     * <p>
     * 备注
     * 1 <= taskNum <= 100000
     * 0 <= startTime < endTime <= 50000
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int taskNum = scanner.nextInt();
            int[][] tasks = new int[taskNum][3];
            for (int i = 0; i < taskNum; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = scanner.nextInt();
            }
            System.out.println(solution(tasks, taskNum));
        }
    }

    public static int solution(int[][] tasks, int taskNum) {
        // 按照任务开始时间排序
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        // 维护一个优先队列，按照结束时间排序
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int res = 0;
        for (int i = 0; i < taskNum; i++) {
            // 如果当前任务开始时间大于优先队列中任务的结束时间，表示该任务可以复用之前的服务器
            while (!pq.isEmpty() && pq.peek() <= tasks[i][0]) {
                pq.poll();
            }
            // 将当前任务的并行度个服务器加入优先队列
            for (int j = 0; j < tasks[i][2]; j++) {
                pq.offer(tasks[i][1]);
            }
            // 记录最大并行度
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
