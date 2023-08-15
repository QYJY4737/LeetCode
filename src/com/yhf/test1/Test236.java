package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test236 {
    /**
     * 题目0236-等和子数组最小和
     * 题目描述
     * 给定一个数组nums，将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，组内元素和的最小值。
     * <p>
     * 输入描述
     * 第一行输入 m
     * 接着输入m个数，表示此数组nums
     * 数据范围：1 <= m <= 50, 1 <= nums[i] <= 50
     * <p>
     * 输出描述
     * 最小拆分数组和
     * <p>
     * 示例一
     * 输入
     * 7
     * 4 3 2 3 5 2 1
     * 输出
     * 5
     * 说明
     * 可以等分的情况有：
     * <p>
     * 4 个子集（5），（1,4），（2,3），（2,3）
     * 2 个子集（5, 1, 4），（2,3, 2,3）
     * 但最小的为5。
     * <p>
     * 思路解析和复杂度分析
     * 这道题目要求将数组拆分为多个组，使每个组的和相等，并求出这样的组中最小的组和。以下是解题思路和复杂度分析：
     * <p>
     * 解题思路
     * 计算数组总和 total。
     * 对数组进行降序排序。
     * 遍历尝试将数组分为 1 到数组长度的多个组。
     * 使用回溯法尝试所有可能的分组方式，检查是否满足条件。
     * a. 如果当前的组和等于目标值 target（total 除以组数），则继续搜索下一个组，直到所有组满足条件。
     * b. 如果当前组和不等于目标值 target，从当前位置开始遍历数组元素，若当前组和加上该元素仍小于等于目标值，则将该元素添加到当前组，继续搜索下一个元素。
     * c. 如果当前组和加上该元素大于目标值，则回溯，将当前元素从组中移除，尝试下一个元素。
     * 如果找到了满足条件的分组，更新 minSum 为这些分组中最小的组和。
     * 复杂度分析
     * 时间复杂度：该算法的时间复杂度较高，最坏情况下为 O(n!)，其中 n 是数组长度。这是因为回溯法在穷举所有可能的分组组合时，时间复杂度较高。然而，实际问题中的数据规模较小（数组长度最大为 50），因此算法在实际问题中的运行时间仍然是可接受的。
     * 空间复杂度：算法的空间复杂度主要取决于递归栈的深度，最坏情况下为 O(n)，因此空间复杂度为 O(n)。
     * 总结
     * 这道题目要求找到一个数组中满足一定条件的分组，并求出这些分组中最小的组和。采用回溯法的思路，通过递归地搜索满足条件的分组组合，可以找到答案。虽然时间复杂度较高，但对于实际问题中的数据规模，算法的运行时间仍然是可接受的。
     */

    private static int minSum = 50 * 50 + 1;
    private static int target;

    private static void backtrack(int[] nums, int index, int m, int sum, int numGroups, int totalSum) {
        if (sum == target) {
            totalSum += sum;
            if (totalSum == target * numGroups) {
                if (sum < minSum) {
                    minSum = sum;
                }
            } else {
                backtrack(nums, 0, m, 0, numGroups - 1, totalSum);
            }
        } else {
            for (int i = index; i < m; ++i) {
                if (sum + nums[i] <= target) {
                    int temp = nums[i];
                    nums[i] = -1;
                    backtrack(nums, i + 1, m, sum + temp, numGroups, totalSum);
                    nums[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        int[] nums = new int[m];
        int total = 0;
        for (int i = 0; i < m; ++i) {
            nums[i] = scanner.nextInt();
            total += nums[i];
        }
        scanner.close();

        Arrays.sort(nums);
        for (int i = 0; i < m / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[m - i - 1];
            nums[m - i - 1] = temp;
        }

        for (int numGroups = 1; numGroups <= m; ++numGroups) {
            if (total % numGroups == 0) {
                target = total / numGroups;
                backtrack(nums, 0, m, 0, numGroups, 0);
            }
        }

        System.out.println(minSum);
    }
}
