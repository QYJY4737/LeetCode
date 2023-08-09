package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test022 {
    /**
     * 题目0022-运动会
     * 题目描述
     * 某学校举行运动会,学生们按编号(1、2、3.....n)进行标识,
     * 现需要按照身高由低到高排列，
     * 对身高相同的人，按体重由轻到重排列，
     * 对于身高体重都相同的人，维持原有的编号顺序关系。
     * 请输出排列后的学生编号
     * <p>
     * 输入描述
     * 两个序列，每个序列由N个正整数组成，(0 < n <= 100)。
     * 第一个序列中的数值代表身高，第二个序列中的数值代表体重。
     * <p>
     * 输出描述
     * 排列结果，每个数据都是原始序列中的学生编号，编号从1开始。
     * <p>
     * 示例一
     * 输入
     * 4
     * 100 100 120 130
     * 40 30 60 50
     * 输出
     * 2 1 3 4
     * 示例一
     * 输入
     * 3
     * 90 110 90
     * 45 60 45
     * 输出
     * 1 3 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String heights = scanner.nextLine();
            String weights = scanner.nextLine();
            solution(n, heights, weights);
        }
    }

    private static void solution(int n, String heights, String weights) {
        String[] heightsArr = heights.split(" ");
        String[] weightsArr = weights.split(" ");
        int[][] ints = new int[n][3];
        for (int i = 0; i < n; i++) {
            ints[i][0] = i + 1;
            ints[i][1] = Integer.parseInt(heightsArr[i]);
            ints[i][2] = Integer.parseInt(weightsArr[i]);
        }
        Arrays.sort(ints, (stu1, stu2) -> {
            if (stu1[1] == stu2[1]) {
                return stu1[2] - stu2[2];
            } else {
                return stu1[1] - stu2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(ints[i][0]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
