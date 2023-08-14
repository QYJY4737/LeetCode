package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test104 {
    /**
     * 题目0104-最大排列
     * 题目描述
     * 给定一组整数，重排序后输出一个最大的整数
     * <p>
     * 输入描述
     * 数字组合
     * <p>
     * 输出描述
     * 最大的整数
     * <p>
     * 示例一
     * 输入
     * 10 9
     * 输出
     * 910
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        Object[] s = Arrays.stream(line.split(" "))
                .sorted((s1, s2) -> {
                    int len1 = s1.length();
                    int len2 = s2.length();
                    int lim = Math.min(len1, len2);
                    char[] v1 = s1.toCharArray();
                    char[] v2 = s2.toCharArray();

                    int k = 0;
                    while (k < lim) {
                        char c1 = v1[k];
                        char c2 = v2[k];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                        k++;
                    }
                    if (len1 > len2) {
                        while (k < len1) {
                            if (v1[k] > v2[0]) {
                                return -1;
                            }
                            k++;
                        }
                        return 1;
                    } else if (len2 > len1) {
                        while (k < len2) {
                            if (v2[k] > v1[0]) {
                                return -1;
                            }
                            k++;
                        }
                        return 1;
                    } else {
                        return 0;
                    }

                })
                .toArray();

        StringBuilder builder = new StringBuilder();
        for (Object o : s) {
            builder.append(o.toString());
        }

        System.out.print(builder);
    }
}
