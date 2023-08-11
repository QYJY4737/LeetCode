package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test097 {
    /**
     * 题目0097-数组组成的最小数字
     * 题目描述
     * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出
     * （如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
     * <p>
     * 输入描述
     * 一行用半角逗号分割的字符串记录的整型数组，
     * 0 < 数组长度 <= 100，
     * 0 < 整数的取值范围 <= 10000。
     * <p>
     * 输出描述
     * 由3个元素组成的最小数字，
     * 如果数组长度小于3，
     * 则选择数组中所有元素来组成最小数字。
     * <p>
     * 示例一
     * 输入
     * 21,30,62,5,31
     * 输出
     * 21305
     * 说明
     * 数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
     * <p>
     * 示例二
     * 输入
     * 5,21
     * 输出
     * 215
     * 说明
     * 数组长度小于3， 选择所有元素来组成最小值，215为最小值。
     */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(",");

        int len = split.length;
        StringBuilder builder = new StringBuilder();

        if (len == 1) {
            builder = new StringBuilder(split[0]);
        } else {
            List<String> list = new ArrayList<>();
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                ints[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(ints);
            int numsLen;
            if (len == 2) {
                numsLen = 2;
            } else {
                numsLen = 3;
            }
            for (int i = 0; i < numsLen; i++) {
                list.add(String.valueOf(ints[i]));
            }
            Collections.sort(list);
            for (int i = 0; i < numsLen; i++) {
                builder.append(list.get(i));
            }
        }
        System.out.println(Integer.valueOf(builder.toString()));

    }
}
