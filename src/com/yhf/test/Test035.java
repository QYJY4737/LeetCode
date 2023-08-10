package com.yhf.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test035 {
    /**
     * 题目0035-流水线
     * 题目描述
     * 一个工厂有m条流水线
     * 来并行完成n个独立的作业
     * 该工厂设置了一个调度系统
     * 在安排作业时，总是优先执行处理时间最短的作业
     * 现给定流水线个数m
     * 需要完成的作业数n
     * 每个作业的处理时间分别为 t1,t2...tn
     * 请你编程计算处理完所有作业的耗时为多少
     * 当n > m时 首先处理时间短的m个作业进入流水线
     * 其他的等待
     * 当某个作业完成时，
     * 依次从剩余作业中取处理时间最短的
     * 进入处理
     * <p>
     * 输入描述
     * 第一行为两个整数(采取空格分隔)
     * 分别表示流水线个数m和作业数n
     * 第二行输入n个整数(采取空格分隔)
     * 表示每个作业的处理时长 t1,t2...tn
     * 0 < m, n< 100
     * 0 < t1,t2...tn < 100
     * <p>
     * 输出描述
     * 输出处理完所有作业的总时长
     * <p>
     * 示例一
     * 输入
     * 3 5
     * 8 4 3 2 10
     * 输出
     * 13
     * 说明
     * 先安排时间为2,3,4的三个作业
     * 第一条流水线先完成作业
     * 调度剩余时间最短的作业8
     * 第二条流水线完成作业
     * 调度剩余时间最短的作业10
     * 总共耗时 就是二条流水线完成作业时间13(3+10)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                jobs.add(scanner.nextInt());
            }
            solution(m, n, jobs);
        }
    }

    private static void solution(int m, int n, List<Integer> jobs) {
        jobs = jobs.stream().sorted().collect(Collectors.toList());
        if (n <= m) {
            System.out.println(Collections.max(jobs).intValue());
            return;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(jobs.get(i));
        }
        for (int i = m; i < jobs.size(); i++) {
            Integer min = res.stream().sorted().iterator().next();
            int index = res.indexOf(min);
            res.set(index, res.get(index) + jobs.get(i));
        }
        Integer maxTime = res.stream().max(Integer::compareTo).get();
        System.out.println(maxTime);
    }
}
