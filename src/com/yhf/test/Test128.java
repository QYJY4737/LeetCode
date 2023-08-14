package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test128 {
    /**
     * 题目0128-符合条件的子串长度
     * 题目描述
     * 给定字符串A、B和正整数V，
     * 字符串A和B的长度相等，
     * 计算A中满足如下条件的最大连续子串的长度：
     *
     * 该连续子串在A和B中的位置和长度相同。
     * 该连续子串|A[i] - B[i]|（两个字母ASCII码之差的绝对值）之和小于等于V
     * 输入描述
     * 第一行输入字符串A，仅包含小写字母，1 <= A.length <= 1000
     * 第二行输入字符串B，仅包含小写字母，1 <= B.length <= 1000
     * 第三行输入正整数V，0 <= V <= 10000
     *
     * 输出描述
     * 字符串最大连续子串的长度，要求该子串|A[i] - B[i]|之和小于等于V
     *
     * 示例一
     * 输入
     * xxcdefg
     * cdefghi
     * 5
     * 输出
     * 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int v = scanner.nextInt();
            solution(a, b, v);
        }
    }


    private static void solution(String a, String b, int v) {
        int max = 0;
        int length = 0;
        List<Integer> list = new ArrayList<>();

        list.add(Math.abs(a.charAt(0) - b.charAt(0)));
        int count = list.get(0);

        for (int i = 1; i < a.length(); i++) {

            int temp = Math.abs(a.charAt(i) - b.charAt(i));

            list.add(temp);
            count += Math.abs(temp);

            if (count <= v) {
                length = list.size();
            } else {
                count -= list.get(0);
                list.remove(0);
            }
            max = Math.max(length, max);
        }

        System.out.println(max);
    }
}
