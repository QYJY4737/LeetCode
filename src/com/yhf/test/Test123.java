package com.yhf.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test123 {
    /**
     * 题目0123-最短耗时
     * 题目描述
     * 给定一个正整型数组表示待系统执行的任务列表，
     * 数组的每一个元素代表一个任务，元素的值表示该任务的类型。
     * 请计算执行完所有任务所需的最短时间。
     * 任务执行规则如下:
     *
     * 任务可以按任意顺序执行，且每个任务执行耗时间均为1个时间单位。
     * 两个同类型的任务之间必须有长度为N个单位的冷却时间，
     * 比如:N为2时，在时间K执行了类型3的任务，
     * 那么K+1和K+2两个时间不能执行类型3任务。
     * 系统在任何一个单位时间内都可以执行一个任务，或者等待状态。
     * 说明:数组最大长度为1000数组最大值1000
     * 输入描述
     * 第一行记录一个用半角逗号分隔的数组，
     * 数组长度不超过1000，数组元素的值不超过1000
     * 第二行记录任务冷却时间，N为正整数，N <= 100。
     *
     * 输出描述
     * 输出为执行完所有任务所需的最短时间。
     *
     * 示例一
     * 输入
     * 2,2,2,3
     * 2
     * 输出
     * 7
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(",");
            int[] jobs = Arrays.stream(split)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int N = scanner.nextInt();
            solution(jobs, N);
        }
    }

    private static void solution(int[] jobs, int n) {
        Map<Integer, Long> jobMap = new HashMap<>(jobs.length);
        for (int job : jobs) {
            jobMap.put(job, jobMap.getOrDefault(job, 0L) + 1);
        }

        List<Long> list = jobMap.values().stream()
                .sorted((i1, i2) -> Long.compare(i2, i1))
                .collect(Collectors.toList());

        int time = 0;


        while (list.size() > 0) {
            if (list.size() == 1 && list.get(0) == 1) {
                time++;
            } else {
                time += n + 1;
            }

            for (int i = 0; i < list.size(); i++) {

                long count = list.get(i);
                if (count > 0) {
                    list.set(i, count - 1);
                }
            }

            list = list.stream().filter(x -> x != 0)
                    .collect(Collectors.toList());
        }
        System.out.println(time);
    }
}
