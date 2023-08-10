package com.yhf.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test042 {
    /**
     * 题目0042-子序列长度
     * 题目描述
     * 有N个正整数组成的一个序列
     * 给定一个整数sum
     * 求长度最长的的连续子序列使他们的和等于sum
     * 返回次子序列的长度
     * 如果没有满足要求的序列 返回-1
     * <p>
     * 输入描述
     * 两行输入
     * 第一行为,拼接的正整数序列
     * 第二行为一个整数sum
     * <p>
     * 输出描述
     * 满足条件的子序列的长度
     * 如果没有满足要求的序列 返回-1
     * <p>
     * 示例一
     * 输入
     * 1,2,3,4,2
     * 6
     * 输出
     * 3
     * 说明
     * 1,2,3和4,2两个序列均能满足要求
     * 所以最长的连续序列为1,2,3，因此结果为3
     * <p>
     * 示例二
     * 输入
     * 1,2,3,4,2
     * 20
     * 输出
     * -1
     * 说明
     * 没有满足要求的子序列，返回-1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> ints = Arrays.stream(scanner.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int sum = Integer.parseInt(scanner.nextLine());
            int max_len = solution(ints, sum);
            System.out.println(max_len);
        }
    }

    private static int solution(List<Integer> ints, int sum) {
        int max_len = 0;
        for (int i = 0; i < ints.size(); i++) {
            int tmp_sum = 0;
            int sub_len = 0;
            for (int j = i; j < ints.size(); j++) {
                if (tmp_sum > sum) {
                    break;
                }
                tmp_sum += ints.get(j);
                sub_len++;
                if (tmp_sum == sum && sub_len > max_len) {
                    max_len = sub_len;
                }
            }
        }
        max_len = max_len == 0 ? -1 : max_len;
        return max_len;
    }
}
