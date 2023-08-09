package com.yhf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test017 {
    /**
     * 题目0017-删除最少字符
     * 题目描述
     * 删除字符串中出现次数最少的字符
     * 如果多个字符出现次数一样则都删除
     * <p>
     * 输入描述
     * 输入只包含小写字母
     * <p>
     * 输出描述
     * 输出删除后剩余的字符
     * 若删除后字符串长度为0，则输出empty
     * <p>
     * 示例一
     * 输入
     * abcdd
     * 输出
     * dd
     * 示例二
     * 输入
     * aabbccdd
     * 输出
     * empty
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        HashMap<Character, Long> map = new HashMap<>();
        for (char c : line.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1L);
        }

        Long[] counts = new Long[map.values().size()];
        Long[] longs = map.values().toArray(counts);
        Arrays.sort(longs);
        Long min = longs[0];
        for (Map.Entry<Character, Long> entry : map.entrySet()) {
            if (entry.getValue().equals(min)) {
                line = line.replaceAll(entry.getKey() + "", "");
            }
        }

        System.out.println(line.length() == 0 ? "empty" : line);
    }
}
