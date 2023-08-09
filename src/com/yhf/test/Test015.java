package com.yhf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test015 {
    /**
     * 题目0015-第k长子串
     * 题目描述
     * 给定一个字符串
     * 只包含大写字母
     * 求在包含同一字母的子串中
     * 长度第K长的子串
     * 相同字母只取最长的子串
     * <p>
     * 输入描述
     * 第一行 一个子串 1 < len <= 100
     * 只包含大写字母
     * 第二行为k的值
     * <p>
     * 输出描述
     * 输出连续出现次数第k多的字母的次数
     * 如果子串中只包含同一字母的子串数小于k
     * 则输出-1
     * <p>
     * 示例一
     * 输入
     * AABAAA
     * 2
     * 输出
     * 1
     * 说明
     * 同一字母连续出现最多的A，3次
     * 第二多2次，但A出现连续3次
     * <p>
     * 示例二
     * 输入
     * AAAAHHHBBCDHHHH
     * 3
     * 输出
     * 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int k = scanner.nextInt();
            solution(line, k);
        }
    }

    private static void solution(String line, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();
        if (chars.length == 0) {
            System.out.println(-1);
            return;
        }

        char cur = chars[0];
        int count = 1;
        map.put(cur, count);

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == cur) count++;
            else {
                cur = c;
                count = 1;
            }
            map.put(cur, map.containsKey(cur) ?
                    map.get(cur) > count ? map.get(cur) : count :
                    count);
        }

        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getKey() + "-" + entry.getValue());
        }
        list.sort((o1, o2) -> o2.split("-")[1].compareTo(o1.split("-")[1]));

        if (k > list.size()) System.out.println(-1);
        else System.out.println(list.get(k - 1).split("-")[1]);
    }
}
