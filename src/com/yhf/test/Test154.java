package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test154 {
    /**
     * 题目0154-新学校选址
     * 题目描述
     * 为了解新学期学生暴涨的问题,小乐村要建立所新学校
     * 考虑到学生上学安全问题,需要所有学生家到学校的距离最短.
     * 假设学校和所有学生家都走在一条直线之上,请问学校建立在什么位置,
     * 能使得到学校到各个学生家的距离和最短
     *
     * 输入描述
     * 第一行: 整数 nnn 取值范围 [1,1000][1,1000][1,1000],表示有 nnn 户家庭。
     * 第二行: 一组整数 mmm 取值范围 [0,10000][0,10000][0,10000] ，表示每户家庭的位置，所有家庭的位置都不相同。
     *
     * 输出描述
     * 一个整数,确定的学校的位置
     * 如果有多个位置,则输出最小的
     *
     * 示例一
     * 输入
     * 5
     * 0 20 40 10 30
     * ¶输出
     * 20
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] sites = new int[n];
            for (int i = 0; i < sites.length; i++) {
                sites[i] = scanner.nextInt();
            }
            int bestSite = solution(sites);
            System.out.print(bestSite);
        }
    }
    private static int solution(int[] sites) {
        Arrays.sort(sites);
        if (sites.length % 2 == 0) {
            return sites[sites.length / 2 - 1];
        } else {
            return sites[sites.length / 2];
        }
    }
}
