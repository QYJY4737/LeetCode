package com.yhf.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test149 {
    /**
     * 题目0149-优选核酸检测点
     * 题目描述
     * 张三要去外地出差，需要做核酸，需要在指定时间点前做完核酸，
     * 请帮他找到满足条件的核酸检测点。
     *
     * 给出一组核酸检测点的距离和每个核酸检测点当前的人数
     * 给出张三要去做核酸的出发时间 出发时间是10分钟的倍数
     * 同时给出张三做核酸的最晚结束时间
     * 题目中给出的距离是整数，单位是公里，时间1分钟为一基本单位
     * 去找核酸点时，有如下的限制：
     *
     * 去往核酸点的路上，每公里距离花费时间10分钟，费用是10元
     * 核酸点每检测一个人的时间花费是1分钟
     * 每个核酸点工作时间都是8点到20点中间不休息
     * 核酸点准时工作，早到晚到都不检测
     * 核酸检测结果可立刻知道
     * 在张三去某个核酸点的路上花费的时间内，此核酸检测点的人数是动态变化的，变化规则是
     * 在非核酸检测时间内，没有人排队
     * 8点-10点每分钟增加3人
     * 12点-14点每分钟增加10人
     * 要求将所有满足条件的核酸检测点按照优选规则排序列出 ：
     * 优选规则：
     *
     * 花费时间最少的核酸检测点排在前面。
     * 花费时间一样,花费费用最少的核酸检测点排在前面。
     * 时间和费用一样，则ID值最小的排在前面
     * 输入描述
     * H1 M1
     * H2 M2
     * N
     * ID1 D1 C1
     * ID2 D2 C2
     * ...
     * IDn Dn Cn
     * H1: 当前时间的小时数。
     * M1：当前时间的分钟数，
     * H2：指定完成核算时间的小时数。
     * M2：指定完成核算时间的分钟数。
     * N：所有核酸检测点个数。
     * ID1：核酸点的ID值。
     * D1：核酸检测点距离张三的距离。
     * C1：核酸检测点当前检测的人数。
     *
     * 输出描述
     * N
     * I2 T2 M2
     * I3 T3 M3
     * N：满足要求的核酸检测点个数
     * I2:选择后的核酸检测点ID
     * T2:做完核酸花费的总时间(分钟)
     * M3:去该核算点花费的费用
     *
     * 示例一
     * 输入
     * 10 30
     * 14 50
     * 3
     * 1 10 19
     * 2 8 20
     * 3 21 3
     * 输出
     * 2
     * 2 80 80
     * 1 190 100
     */

    private static class Point {
        int id;
        int dis;
        int que;
        int pay;
        int time;
    }

    private static final int[] add8_10 = {3, 480, 600};
    private static final int[] add12_14 = {10, 720, 840};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int start = scanner.nextInt() * 60 + scanner.nextInt();
            int end = scanner.nextInt() * 60 + scanner.nextInt();
            int n = scanner.nextInt();
            Point[] points = new Point[n];
            for (int i = 0; i < points.length; i++) {
                Point point = new Point();
                point.id = scanner.nextInt();
                point.dis = scanner.nextInt();
                point.que = scanner.nextInt();
                point.pay = point.dis * 10;
                point.time = getTime(start, point);
                points[i] = point;
            }
            solution(start, end, points);
        }
    }

    private static int getTime(int start, Point point) {
        int time = 0;
        // 累加路程时间
        time += point.dis * 10;
        // 去除路程中的排队人数
        point.que = Math.max(0, point.que - point.dis * 10);
        // 到监测点的时间
        int on = start + point.dis * 10;
        // 8点前到
        if (on <= add8_10[1]) {
            return add8_10[1] - start;
        }
        // 8点-10点到
        if (on <= add8_10[2]) {
            point.que += (on - add8_10[1]) * add8_10[0] - (on - add8_10[1]);
            return time + point.que;
        }

        // 10-12点到
        if (on <= add12_14[1]) {
            return time + point.que;
        }

        // 12-14点到
        if (on <= add12_14[2]) {
            point.que += (on - add12_14[1]) * add12_14[0] - (on - add12_14[1]);
            return time + point.que;
        }
        // 14点以后
        return time + point.que;
    }

    private static void solution(int start, int end, Point[] points) {
        List<Point> res = Arrays.stream(points).filter(p -> start + p.time < end)
                .sorted((p1, p2) -> {
                    if (p1.time != p2.time) {
                        return p1.time - p2.time;
                    } else {
                        return p1.pay - p2.pay;
                    }
                }).collect(Collectors.toList());
        System.out.println(res.size());
        for (Point p : res) {
            System.out.printf("%d %d %d \n", p.id, p.time, p.pay);
        }
    }
}
