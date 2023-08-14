package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test169 {
    /**
     * 题目0169-通信误码
     * 题目描述
     * 信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，取值范围为1~65535，用一个数组记录误码出现的情况，每个误码出现的次数代表误码频度，请找出记录中包含频度最高误码的最小子数组长度。
     * <p>
     * 输入描述
     * 误码总数目：取值范围为0~255，取值为0表示没有误码的情况。
     * 误码出现频率数组：误码ID范围为1~65535，数组长度为1~1000。
     * <p>
     * 输出描述
     * 包含频率最高的误码最小子数组长度
     * <p>
     * 示例一
     * 输入
     * 5 1 2 2 4 1
     * 输出
     * 2
     * 说明
     * 频度最高的有1和2，频度是2（出现的次数都是2）。
     * 可以包含频度最高的记录数组是[2 2]和[1 2 2 4 1]，
     * 最短是[2 2]，最小长度为2
     * <p>
     * 示例二
     * 输入
     * 7 1 2 2 4 2 1 1
     * 输出
     * 4
     * 说明
     * 频度最高的是1和2，最短的是[2 2 4 2]
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int len = Integer.MAX_VALUE;
        if (line.length() == 0) {
            return 0;
        }
        String[] split = line.trim().split(" ");
        int[] ints = new int[split.length];
        int maxCount = 0;
        Set<Integer> maxCode = new HashSet<>();
        Map<Integer, Integer> codeCount = new HashMap<>();
        for (int i = 1; i < split.length; i++) {
            int code = Integer.parseInt(split[i]);
            ints[i] = code;
            int count = codeCount.getOrDefault(code, 0) + 1;
            maxCount = Math.max(maxCount, count);
            codeCount.put(code, count);
        }

        for (Map.Entry<Integer, Integer> entry : codeCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                maxCode.add(entry.getKey());
            }
        }
        for (Integer i : maxCode) {
            int lo = 0, hi = ints.length - 1;
            while (ints[lo] != i) {
                lo++;
            }
            while (ints[hi] != i) {
                hi--;
            }
            if (lo <= hi) {
                len = Math.min(len, hi - lo + 1);
            }
        }

        return len;
    }
}
