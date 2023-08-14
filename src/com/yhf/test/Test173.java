package com.yhf.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test173 {
    /**
     * 题目0173-任务总执行时长
     * 题目描述
     * 任务编排服务负责对任务进行组合调度。参与编排的任务又两种类型，其中一种执行时长为taskA，另一种执行时长为taskB。任务一旦开始执行不能被打断，且任务可连续执行。服务每次可以编排num个任务。
     * 请编写一个方法，生成每次编排后的任务所有可能的总执行时长。
     * <p>
     * 输入描述
     * 第一行输入分别为:
     * 第一种任务的执行时长taskA，
     * 第二种任务的执行时长taskB，
     * 这次要编排的任务个数num，以逗号分隔。
     * 输出描述
     * 数组形式返回所有总执行时间时长，需要按从小到大排列。
     * <p>
     * 示例一
     * 输入
     * 1,2,3
     * 输出
     * [3, 4, 5, 6]
     * 说明
     * 可以执行3次taskA，得到结果3；
     * 执行2次taskA，和1次taskB得到结果4；
     * 以此类推，得到最终结果。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    private static void solution(String input) {
        String[] split = input.split(",");
        int taskA = Integer.parseInt(split[0]);
        int taskB = Integer.parseInt(split[1]);
        int num = Integer.parseInt(split[2]);
        TreeSet<Integer> times = new TreeSet<>();
        for (int i = 0; i <= num; i++) {
            times.add(i * taskA + (num - i) * taskB);
        }
        System.out.println(times);
    }
}
