package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test187 {
    /**
     * 题目0187-数组的中心位置
     * 题目描述
     * 给你一个整数数组nums,请计算数组的中心位置。
     * 数组中心位置是数组的一个下标，其左侧所有元素相乘的积等于右侧所有元素相乘的积。
     * 数组第一个元素的左侧积为1，最后一个元素的右侧积为1。
     * 如果数组有多个中心位置，应该返回最靠近左边的那一个。
     * 如果数组不存在中心位置，返回-1。
     * <p>
     * 输入描述
     * 输入只有一行，给出 NNN 个正整数用空格分格：nums = 2 5 3 6 5 6
     * 1 <= nums.length <= 1024
     * 1 <= nums[i] <= 10
     * <p>
     * 输出描述
     * 输出：3
     * <p>
     * 示例一
     * 输入
     * 2 5 3 6 5 6
     * 输出
     * 3
     * 说明
     * 中心位置是3。
     * 左侧数之积 sum = nums[0] * nums[1] * nums[2] = 2 * 5 * 3 = 30 ，
     * 右侧数之积 sum = nums[4] * nums[5] = 5 * 6 = 30 ，二者相等。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int lPro = 1, rPro = 1;

        String[] split = line.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
            rPro *= ints[i];
        }


        for (int i = 0; i < ints.length; i++) {
            rPro /= ints[i];
            if (lPro == rPro) {
                return i;
            }
            lPro *= ints[i];
        }

        return -1;
    }
}
