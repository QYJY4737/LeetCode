package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test251 {
    /**
     * 题目0251-跳格子2
     * 题目描述
     * 小明和朋友玩跳格子游戏，有 n 个连续格子组成的圆圈，每个格子有不同的分数，小朋友可以选择以任意格子起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈;
     * <p>
     * 给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数。
     * <p>
     * 输入描述
     * 给定一个数例，第一个格子和最后一个格子首尾相连，如: 2 3 2
     * <p>
     * 输出描述
     * 输出能够得到的最高分，如: 3
     * <p>
     * 备注
     * 1≤nums.length≤1001 \leq nums.length \leq 1001≤nums.length≤100
     * 1≤nums[i]≤10001 \leq nums[i] \leq 10001≤nums[i]≤1000
     * <p>
     * 示例一
     * 输入
     * 2 3 2
     * 输出
     * 3
     * 说明
     * 只能跳3这个格子，因为第一个格子和第三个格子首尾相连
     * <p>
     * 示例二
     * 输入
     * 1 2 3 1
     * 输出
     * 4
     * 说明
     * 1 + 3 = 4
     * <p>
     * ¶思路解析和复杂度分析
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");
            int[] nums = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }
            System.out.println(solution(nums));
        }
    }

    public static int solution(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private static int rob(int[] nums, int start, int end) {
        int pre2 = 0, pre1 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
