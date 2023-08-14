package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test146 {
    /**
     * 题目0146-最左侧冗余覆盖子串
     * 题目描述
     * 给定两个字符串s1和s2和正整数K，其中s1长度为n1，s2长度为n2，
     * 在s2中选一个子串，满足:
     *
     * 该子串长度为n1+k
     * 该子串中包含s1中全部字母，
     * 该子串每个字母出现次数不小于s1中对应的字母，
     * 我们称s2以长度k冗余覆盖s1，
     * 给定s1，s2，k,
     * 求最左侧的s2以长度k冗余覆盖s1的子串的首个元素的下标，
     * 如果没有返回-1。
     *
     * 输入描述
     * 输入三行，
     * 第一行为s1，
     * 第二行为s2，
     * 第三行为k，
     * s1和s2只包含小写字母
     *
     * 输出描述
     * 最左侧的s2以长度k冗余覆盖s1的子串首个元素下标，如果没有返回-1
     *
     * 示例一
     * 输入
     * ab
     * aabcd
     * 1
     * 输出
     * 0
     * 说明
     * 示例二
     * 输入
     * abc
     * dfs
     * 10
     * 输出
     * -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int k = scanner.nextInt();
            int res = solution(s1, s2, k);
            System.out.print(res);
        }
    }

    private static int solution(String s1, String s2, int k) {
        int len = s1.length() + k;
        if (s2.length() < len) {
            return -1;
        }
        Map<Character, Integer> s1wc = getWC(s1);

        for (int i = 0; i < s2.length() - len; i++) {
            String substring = s2.substring(i, i + len);
            Map<Character, Integer> sub_wc = getWC(substring);
            boolean flag = true;
            for (Character key : s1wc.keySet()) {
                if (s1wc.get(key) > sub_wc.getOrDefault(key, 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }

    private static Map<Character, Integer> getWC(String s1) {
        Map<Character, Integer> wc = new HashMap<>();
        for (char c : s1.toCharArray()) {
            wc.put(c, wc.getOrDefault(c, 0) + 1);
        }
        return wc;
    }
}
