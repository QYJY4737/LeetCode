package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test171 {
    /**
     * 题目0171-相同数字的积木游戏1
     * 题目描述
     * 小华和小薇一起通过玩积木游戏学习数学。
     * 他们有很多积木，每个积木块上都有一个数字，
     * 积木块上的数字可能相同。
     * 小华随机拿一些积木挨着排成一排，请小薇找到这排积木中数字相同且所处位置最远的2块积木块，计算他们的距离。
     * 小薇请你帮忙替她解决这个问题。
     * <p>
     * 输入描述
     * 第一行输入为 NNN ，表示小华排成一排的积木总数。
     * 接下来 NNN 行每行一个数字，表示小花排成一排的积木上数字。
     * <p>
     * 输出描述
     * 相同数字的积木的位置最远距离；
     * 如果所有积木数字都不相同，请返回 -1
     * <p>
     * 示例一
     * 输入
     * 5
     * 1
     * 2
     * 3
     * 1
     * 4
     * 输出
     * 3
     * 示例一
     * 输入
     * 2
     * 1
     * 2
     * 输出
     * -1
     * 备注
     * 0 <= 积木上的数字 < 10^9
     * 1 <= 积木长度 <= 10^5
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            int res = solution(ints);
            System.out.println(res);
        }
    }

    private static int solution(int[] ints) {
        int maxLen = -1;
        if (ints.length == 0) {
            return maxLen;
        }
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i : ints) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }
        if (numCount.entrySet().size() == ints.length) {
            return maxLen;
        }


        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            Integer number = entry.getKey();
            Integer count = entry.getValue();
            if (count < 2) {
                continue;
            }
            int lo = 0, hi = ints.length - 1;
            while (ints[lo] != number) {
                lo++;
            }
            while (ints[hi] != number) {
                hi--;
            }
            maxLen = Math.max(maxLen, hi - lo);
        }
        return maxLen;
    }
}
