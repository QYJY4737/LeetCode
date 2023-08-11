package com.yhf.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test070 {
    /**
     * 题目0070-字母计数
     * 题目描述
     * 给出一个只包含字母的字符串,
     * 不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
     * 并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
     * 如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
     * <p>
     * 输入描述
     * 输入一行仅包含字母的字符串
     * <p>
     * 输出描述
     * 按照字母出现次数从大到小的顺序输出各个字母和字母次数,
     * 用英文分号分割,
     * 注意末尾的分号
     * 字母和次数中间用英文冒号分隔
     * <p>
     * 示例一
     * 输入
     * xyxyXX
     * 输出
     * x:2;y:2;X:2;
     * 说明
     * 每个字符出现的次数为2 故x排在y之前
     * 而小写字母x在大写X之前
     * <p>
     * 示例二
     * 输入
     * abababb
     * 输出
     * b:4;a:3;
     * 说明
     * b的出现个数比a多 故排在a前
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        char[] chars = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = map.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    char c1 = e1.getKey();
                    char c2 = e2.getKey();
                    int count1 = e1.getValue();
                    int count2 = e2.getValue();
                    if (count1 != count2) {
                        return Integer.compare(count2, count1);
                    }
                    if ((c1 < 95 && c2 < 95) || (c1 > 95 && c2 > 95)) {
                        return c1 - c2;
                    } else {
                        return c2 - c1;
                    }
                })
                .collect(Collectors.toList());
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + ";");
        }
    }
}
