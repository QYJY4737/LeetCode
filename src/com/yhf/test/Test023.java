package com.yhf.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test023 {
    /**
     * 题目0023-乱序整数序列两数之和绝对值最小
     * 题目描述
     * 给定一个随机的整数数组(可能存在正整数和负整数)nums,
     * 请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
     * 并返回这两个数(按从小到大返回)以及绝对值。
     * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 输入描述
     * 一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
     * 且整数数值范围是[-65535,65535]
     * <p>
     * 输出描述
     * 两个数和两数之和绝对值
     * <p>
     * 示例一
     * 输入
     * -1 -3 7 5 11 15
     * 输出
     * -3 5 2
     * 说明
     * 因为|nums[0]+nums[2]|=|-3+5|=2最小，
     * 所以返回-3 5 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String numsStr = scanner.nextLine();
            solution(numsStr);
        }
    }

    private static void solution(String numsStr) {
        String[] nums = numsStr.split(" ");
        List<Integer> list = Arrays.stream(nums)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        int min = Integer.MAX_VALUE;

        Set<Integer> resSet = new TreeSet<>();

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                Integer a = list.get(i);
                Integer b = list.get(j);
                int sum = Math.abs(a + b);
                if (sum < min && !a.equals(b)) {
                    min = sum;
                    resSet.clear();
                    resSet.add(a);
                    resSet.add(b);
                }
            }
        }

        if (resSet.size() != 0) {
            for (Integer integer : resSet) {
                System.out.print(integer + " ");
            }
            System.out.println(min);
        }
    }
}
