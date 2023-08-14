package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test211 {
    /**
     * 题目0211-租车骑绿岛
     * 题目描述
     * 部门组织绿道骑行团建活动。租用公共双人自行车骑行，每辆自行车最多坐两人、最大载重 MMM。
     * 给出部门每个人的体重，请问最多需要租用多少双人自行车。
     * <p>
     * 输入描述
     * 第一行两个数字 mmm、nnn，自行车限重 mmm，代表部门总人数 nnn。
     * 第二行，nnn 个数字，代表每个人的体重。体重都小于等于自行车限重 mmm。
     * 0<m≤2000 < m \leq 2000<m≤200
     * 0<n≤10000000 < n \leq 10000000<n≤1000000
     * <p>
     * 输出描述
     * 最小需要的双人自行车数量。
     * <p>
     * 示例一
     * 输入
     * 3 4
     * 3 2 2 1
     * 输出
     * 3
     * 思路
     * 将所有人体重从小到大排序
     * 从右找最大体重
     * 如果体重超过上限，直接忽略
     * 如果体重等于上限，独占一车
     * 如果体重小于上限，从左找是否有可以与其共享一两车的人
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }
            int res = solution(m, weights);
            System.out.println(res);
        }
    }

    public static int solution(int m, int[] weights) {
        Arrays.sort(weights);
        int count = 0;
        int left = 0;
        int right = weights.length - 1;

        while (left <= right) {
            if (weights[left] + weights[right] <= m) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}
