package com.yhf.test1;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test207 {
    /**
     * 题目0207-最少数量线段覆盖
     * 题目描述
     * 给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于 111，
     * 请你从中找到最少数量的线段，这些线段可以覆盖住所有线段。
     * <p>
     * 输入描述
     * 第一行输入为所有线段的数量，不超过 100001000010000 ，
     * 后面每行表示一条线段，格式为 x,yx,yx,y，xxx 和 yyy 分别表示起点和终点，取值范围是 [−105,105][-10^5 , 10^5][−10
     * 5
     * ,10
     * 5
     * ]。
     * <p>
     * 输出描述
     * 最少线段数量，为正整数。
     * <p>
     * 示例一
     * 输入
     * 3
     * 1,4
     * 2,5
     * 3,6
     * 输出
     * 2
     * 说明
     * 选取2条线段[1,4]和[3,6]即可，这两条线段可以覆盖[2,5]
     * <p>
     * 思路
     * 用一个TreeMap模拟数轴，key表示数轴上的整数点，value表示每个点被覆盖的次数；
     * 将所有的线段存入数轴，如果出现过则覆盖次数递增；
     * 逐个线段验证，删除当前线段后，数轴的点是否依然被完全覆盖，若删除后依然被覆盖，则删除当前线段并计数
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] split = scanner.nextLine().split(",");
                points[i] = new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
            }
            int res = solution(n, points);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[][] points) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            for (int j = point[0]; j <= point[1]; j++) {
                line.put(j, line.getOrDefault(j, 0) + 1);
            }
        }
        int del = 0;
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            boolean deletable = true;
            for (int j = point[0]; j <= point[1]; j++) {
                if (line.get(j) <= 1) {
                    deletable = false;
                    break;
                }
            }
            if (deletable) {
                for (int j = point[0]; j <= point[1]; j++) {
                    line.put(j, line.get(j) - 1);
                }
                del++;
            }
        }

        return n - del;
    }
}
